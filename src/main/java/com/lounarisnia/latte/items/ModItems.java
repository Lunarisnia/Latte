package com.lounarisnia.latte.items;

import com.lounarisnia.latte.Latte;
import com.lounarisnia.latte.blocks.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {

  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Latte.MODID);

  public static final DeferredItem<CafeLatteItem> CAFE_LATTE_ITEM =
      ITEMS.registerItem("cafe_latte", CafeLatteItem::new);

  public static final DeferredItem<CoffeeMachineItem> COFFEE_MACHINE_ITEM =
      ITEMS.registerItem(
          "coffee_machine_item",
          properties -> new CoffeeMachineItem(ModBlocks.COFFEE_MACHINE_BLOCK.get(), properties));

  public static final DeferredItem<CoffeeBeanItem> COFFEE_BEAN_ITEM =
      ITEMS.registerItem("coffee_bean", CoffeeBeanItem::new);

  public static void register(IEventBus modEventBus) {
    ITEMS.register(modEventBus);
  }
}
