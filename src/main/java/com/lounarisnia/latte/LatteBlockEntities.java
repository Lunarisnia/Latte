package com.lounarisnia.latte;

import com.lounarisnia.latte.blocks.MeasuringCupBlockEntity;
import com.lounarisnia.latte.machines.CoffeeMachineBlockEntity;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class LatteBlockEntities {

  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
      DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Latte.MODID);

  public static final Supplier<BlockEntityType<CoffeeMachineBlockEntity>>
      COFFEE_MACHINE_BLOCK_ENTITY =
          BLOCK_ENTITIES.register(
              "coffee_machine_block_entity",
              () ->
                  new BlockEntityType<>(
                      CoffeeMachineBlockEntity::new,
                      false,
                      LatteBlocks.COFFEE_MACHINE_BLOCK.get()));

  public static final Supplier<BlockEntityType<MeasuringCupBlockEntity>>
      MEASURING_CUP_BLOCK_ENTITY =
          BLOCK_ENTITIES.register(
              "measuring_cup_block_entity",
              () ->
                  new BlockEntityType<>(
                      MeasuringCupBlockEntity::new, false, LatteBlocks.MEASURING_CUP_BLOCK.get()));

  public static void register(IEventBus modEventBus) {
    BLOCK_ENTITIES.register(modEventBus);
  }
}
