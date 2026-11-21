package com.lounarisnia.latte.blocks;

import com.lounarisnia.latte.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class CoffeeMachineBlock extends Block implements EntityBlock {

    public static BooleanProperty PORTA_FILTER = BooleanProperty.create(
        "porta_filter"
    );

    public CoffeeMachineBlock(Properties properties) {
        super(properties.sound(SoundType.ANVIL).noOcclusion());
        registerDefaultState(defaultBlockState().setValue(PORTA_FILTER, false));
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(
        BlockPos pos,
        BlockState state
    ) {
        return new CoffeeMachineBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(
        Builder<Block, BlockState> builder
    ) {
        super.createBlockStateDefinition(builder);

        builder.add(PORTA_FILTER);
    }

    @Override
    protected VoxelShape getShape(
        BlockState state,
        BlockGetter level,
        BlockPos pos,
        CollisionContext context
    ) {
        final VoxelShape shape = Block.box(5, 0, 3, 11, 11, 14);
        return shape;
    }

    @Override
    protected void tick(
        BlockState state,
        ServerLevel level,
        BlockPos pos,
        RandomSource random
    ) {
        level.setBlock(
            pos,
            state.setValue(CoffeeMachineBlock.PORTA_FILTER, false),
            Block.UPDATE_ALL
        );

        Vec3 center = Vec3.atCenterOf(pos);
        for (Player player : level.players()) {
            if (player.distanceToSqr(center) <= 16 * 16) {
                player.displayClientMessage(
                    Component.literal("Coffee is ready!"),
                    true
                );
            }
        }

        if (
            level.getBlockEntity(pos) instanceof
                CoffeeMachineBlockEntity machine
        ) {
            Player player = level
                .getServer()
                .getPlayerList()
                .getPlayer(machine.getBrewerId());

            ItemStack coffee = new ItemStack(ModItems.CAFE_LATTE_ITEM.get());
            if (!player.getInventory().add(coffee)) {
                player.drop(coffee, false);
            }
        }
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
            BlockState updatedState = state.setValue(PORTA_FILTER, true);
            level.setBlock(pos, updatedState, Block.UPDATE_ALL);

            if (
                level.getBlockEntity(pos) instanceof
                    CoffeeMachineBlockEntity machine
            ) {
                machine.setBrewerId(player.getUUID());
            }

            level.scheduleTick(pos, this, 40);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected InteractionResult useItemOn(
        ItemStack stack, // The currently held item
        BlockState state, // The state of the current item IMMUTABLE
        Level level,
        BlockPos pos,
        Player player,
        InteractionHand hand,
        BlockHitResult hitResult
    ) {
        // TODO: Add porta filter here

        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }
}
