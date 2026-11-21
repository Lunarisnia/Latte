package com.lounarisnia.latte.blocks;

import com.lounarisnia.latte.Latte;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {

    public static DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(Latte.MODID);

    public static DeferredBlock<CoffeeMachineBlock> COFFEE_MACHINE_BLOCK =
        BLOCKS.registerBlock("coffee_machine_block", CoffeeMachineBlock::new);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
