package com.lounarisnia.latte.gametest;

import com.lounarisnia.latte.Latte;
import com.lounarisnia.latte.LatteBlocks;
import com.lounarisnia.latte.machines.CoffeeMachineBlockEntity;
import java.util.function.Consumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class CoffeeMachineTests {
  private static final DeferredRegister<Consumer<GameTestHelper>> TEST_FUNCTIONS =
      DeferredRegister.create(BuiltInRegistries.TEST_FUNCTION, Latte.MODID);

  static {
    TEST_FUNCTIONS.register(
        "coffee_machine_creates_block_entity", () -> CoffeeMachineTests::createsBlockEntity);
  }

  public static void register(IEventBus modEventBus) {
    TEST_FUNCTIONS.register(modEventBus);
  }

  private static void createsBlockEntity(GameTestHelper helper) {
    BlockPos pos = BlockPos.ZERO;
    helper.setBlock(pos, LatteBlocks.COFFEE_MACHINE_BLOCK.get());
    helper.assertTrue(
        helper.getLevel().getBlockEntity(helper.absolutePos(pos))
            instanceof CoffeeMachineBlockEntity,
        Component.literal("Placing a coffee machine should create its block entity"));
    helper.succeed();
  }
}
