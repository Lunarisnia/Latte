package com.lounarisnia.latte.items;

import net.minecraft.SharedConstants;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class CafeLatteItem extends Item {
	public CafeLatteItem(Item.Properties properties) {
		super(properties.food(new FoodProperties.Builder()
						.nutrition(1)
						.build(),
				Consumables.defaultDrink()
						.onConsume(new ApplyStatusEffectsConsumeEffect(
								new MobEffectInstance(
										MobEffects.SPEED,
										30 * SharedConstants.TICKS_PER_SECOND,
										1
								),
								1.0f
						))
						.build()
		));
	}
}
