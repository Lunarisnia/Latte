package com.lounarisnia.latte.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ScaleBlock extends Block {
  private static final VoxelShape SHAPE = Block.box(2.5, 0, 2, 13.5, 2, 14);

  public ScaleBlock(Properties properties) {
    super(properties.noOcclusion());
  }

  @Override
  protected VoxelShape getShape(
      BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }
}
