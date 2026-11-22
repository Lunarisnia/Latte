package com.lounarisnia.latte;

import com.lounarisnia.latte.items.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class LatteItems {

  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Latte.MODID);

  public static final DeferredItem<CafeLatteItem> CAFE_LATTE_ITEM =
      ITEMS.registerItem("cafe_latte_item", CafeLatteItem::new);

  public static final DeferredItem<CoffeeMachineItem> COFFEE_MACHINE_ITEM =
      ITEMS.registerItem(
          "coffee_machine_item",
          properties -> new CoffeeMachineItem(LatteBlocks.COFFEE_MACHINE_BLOCK.get(), properties));

  public static final DeferredItem<CoffeeBeanItem> COFFEE_BEAN_ITEM =
      ITEMS.registerItem("coffee_bean_item", CoffeeBeanItem::new);

  public static final DeferredItem<MeasuringCupItem> MEASURING_CUP_ITEM =
      ITEMS.registerItem(
          "measuring_cup_item",
          properties -> new MeasuringCupItem(LatteBlocks.MEASURING_CUP_BLOCK.get(), properties));

  public static DeferredItem<CoffeePackageItem> COFFEE_PACKAGE_ITEM =
      ITEMS.registerItem("coffee_package_item", CoffeePackageItem::new);

  public static void register(IEventBus modEventBus) {
    ITEMS.register(modEventBus);
  }
}
