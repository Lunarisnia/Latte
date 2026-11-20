package com.lounarisnia.latte.blocks;

import com.lounarisnia.latte.items.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CoffeeMachineBlock extends Block {

    public CoffeeMachineBlock(Properties properties) {
        super(properties.sound(SoundType.ANVIL).noOcclusion());
    }

    @Override
    protected InteractionResult useWithoutItem(
        BlockState state,
        Level level,
        BlockPos pos,
        Player player,
        BlockHitResult hitResult
    ) {
        if (!level.isClientSide()) {
            ItemStack coffee = new ItemStack(ModItems.CAFE_LATTE_ITEM.get());

            if (!player.getInventory().add(coffee)) {
                player.drop(coffee, false);
            }

        }

        return InteractionResult.SUCCESS;
    }
}
