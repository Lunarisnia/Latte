package com.lounarisnia.latte.blocks;

import com.lounarisnia.latte.LatteItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class MeasuringCupBlock extends Block implements EntityBlock {

	private static final VoxelShape SHAPE = Block.box(5.7, 0, 6.7, 10.3, 5, 11.3);

	public MeasuringCupBlock(Properties properties) {
		super(properties.noOcclusion());
	}

	@Override
	public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new MeasuringCupBlockEntity(blockPos, blockState);
	}

	@Override
	protected VoxelShape getShape(
			BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	protected InteractionResult useItemOn(
			ItemStack stack,
			BlockState state,
			Level level,
			BlockPos pos,
			Player player,
			InteractionHand hand,
			BlockHitResult hitResult) {
		if (!level.isClientSide()) {
			if (stack.is(LatteItems.COFFEE_PACKAGE_ITEM.get())) {
				return InteractionResult.SUCCESS_SERVER;
			}
		}

		return InteractionResult.FAIL;
	}
}
