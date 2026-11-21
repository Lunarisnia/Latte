package com.lounarisnia.latte.blocks;

import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class CoffeeMachineBlockEntity extends BlockEntity {

    private String brewerId = "-";

    public CoffeeMachineBlockEntity(BlockPos pos, BlockState blockState) {
        super(
            ModBlockEntities.COFFEE_MACHINE_BLOCK_ENTITY.get(),
            pos,
            blockState
        );
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);

        this.brewerId = input.getStringOr("brewerId", "-");
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putString("brewerId", this.brewerId);
    }

    public void setBrewerId(UUID brewerId) {
        this.brewerId = brewerId.toString();
        setChanged();
    }

    public UUID getBrewerId() {
        return UUID.fromString(brewerId);
    }
}
