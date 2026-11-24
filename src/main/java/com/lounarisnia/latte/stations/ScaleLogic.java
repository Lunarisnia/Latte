package com.lounarisnia.latte.stations;

import com.lounarisnia.latte.Latte;
import com.lounarisnia.latte.LatteItems;
import com.pockyl.diegesis.api.state.SlotRef;
import com.pockyl.diegesis.api.station.StationContext;
import com.pockyl.diegesis.api.station.StationLogic;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ScaleLogic implements StationLogic {

  public ScaleLogic(StationContext stationContext) {}

  @Override
  public void onSlotChanged(StationContext station, SlotRef slot) {
    // NOTE: might need to scope it to each slot
    ItemStack stack = station.state().getItem(slot);
    if (!stack.isEmpty() && stack.is(LatteItems.COFFEE_PACKAGE_ITEM.get())) {
      station.effect(Identifier.fromNamespaceAndPath(Latte.MODID, "tilt"), "bean_pack");
    } else {
      station.effect(Identifier.fromNamespaceAndPath(Latte.MODID, "shake"), "bean_pack");
    }
  }

  @Override
  public void onCustomAction(
      StationContext station, Player player, String action, CompoundTag data) {
    if (!"take_bean_pack".equals(action)) {
      return;
    }

    SlotRef slot = new SlotRef("bean_pack", 0);
    ItemStack stack = station.state().getItem(slot);

    if (stack.isEmpty()
        || !player.inventoryMenu.getCarried().isEmpty()
        || !mayTake(station, player, slot)) {
      return;
    }

    ItemStack taken = stack.copy();
    station.state().setItem(slot, ItemStack.EMPTY);
    player.inventoryMenu.setCarried(taken);
  }
}
