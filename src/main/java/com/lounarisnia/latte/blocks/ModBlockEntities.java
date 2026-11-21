package com.lounarisnia.latte.blocks;

import com.lounarisnia.latte.Latte;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Latte.MODID);

    public static final Supplier<
        BlockEntityType<CoffeeMachineBlockEntity>
    > COFFEE_MACHINE_BLOCK_ENTITY = BLOCK_ENTITIES.register(
        "coffee_machine_block_entity",
        () ->
            new BlockEntityType<>(
                CoffeeMachineBlockEntity::new,
                false,
                ModBlocks.COFFEE_MACHINE_BLOCK.get()
            )
    );

    public static void register(IEventBus modEventBus) {
        BLOCK_ENTITIES.register(modEventBus);
    }
}
