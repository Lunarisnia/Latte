package com.lounarisnia.latte.items;

import com.lounarisnia.latte.ModAttachments;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.level.Level;

public class CafeLatteItem extends Item {
  public CafeLatteItem(Item.Properties properties) {
    super(
        properties.food(
            new FoodProperties.Builder().nutrition(1).build(),
            Consumables.defaultDrink()
                .onConsume(
                    new ApplyStatusEffectsConsumeEffect(
                        new MobEffectInstance(
                            MobEffects.SPEED, 30 * SharedConstants.TICKS_PER_SECOND, 1),
                        1.0f))
                .build()));
  }

  @Override
  public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
    ItemStack result = super.finishUsingItem(stack, level, entity);

    if (!level.isClientSide()) {
      // Server side action
      if (entity instanceof ServerPlayer player) {
        int count = player.getData(ModAttachments.DRINK_COUNT);

        player.setData(ModAttachments.DRINK_COUNT, ++count);

        if (count > 3) {
          player.displayClientMessage(Component.literal("You drank more than 3 coffees"), true);
        }
      }
    }

    return result;
  }
}
