package com.lounarisnia.latte.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MeasuringCupBlock extends Block {

	private static final VoxelShape SHAPE = Block.box(5.7, 0, 6.7, 10.3, 5, 11.3);

	public MeasuringCupBlock(Properties properties) {
		super(properties.noOcclusion());
	}

	@Override
	protected VoxelShape getShape(
			BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
}
