package com.lounarisnia.latte;

import com.lounarisnia.latte.blocks.CoffeeMachineBlock;
import com.lounarisnia.latte.blocks.MeasuringCupBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class LatteBlocks {

  public static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Latte.MODID);

  public static DeferredBlock<CoffeeMachineBlock> COFFEE_MACHINE_BLOCK =
      BLOCKS.registerBlock("coffee_machine_block", CoffeeMachineBlock::new);

  public static DeferredBlock<MeasuringCupBlock> MEASURING_CUP_BLOCK =
      BLOCKS.registerBlock("measuring_cup_block", MeasuringCupBlock::new);

  public static void register(IEventBus modEventBus) {
    BLOCKS.register(modEventBus);
  }
}
