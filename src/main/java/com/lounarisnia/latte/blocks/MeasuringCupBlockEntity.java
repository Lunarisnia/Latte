package com.lounarisnia.latte.blocks;

import com.lounarisnia.latte.LatteBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MeasuringCupBlockEntity extends BlockEntity {
	public MeasuringCupBlockEntity(BlockPos pos, BlockState blockState) {
		super(LatteBlockEntities.MEASURING_CUP_BLOCK_ENTITY.get(), pos, blockState);
	}
}
