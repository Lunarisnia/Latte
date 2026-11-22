package com.lounarisnia.latte;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LatteTab {
  public static final DeferredRegister<CreativeModeTab> LATTE_TAB =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Latte.MODID);

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> LATTE_TAB_HOLDER =
      LATTE_TAB.register(
          "latte_tab",
          () ->
              CreativeModeTab.builder()
                  .title(Component.literal("Latte"))
                  .icon(() -> LatteItems.CAFE_LATTE_ITEM.get().getDefaultInstance())
                  .displayItems(
                      ((itemDisplayParameters, output) -> {
                        output.accept(LatteItems.CAFE_LATTE_ITEM);
                        output.accept(LatteItems.COFFEE_MACHINE_ITEM);
                        output.accept(LatteItems.COFFEE_BEAN_ITEM);
                        output.accept(LatteItems.MEASURING_CUP_ITEM);
                        output.accept(LatteItems.COFFEE_PACKAGE_ITEM);
                      }))
                  .build());

  public static void register(IEventBus modEventBus) {
    LATTE_TAB.register(modEventBus);
  }
}
