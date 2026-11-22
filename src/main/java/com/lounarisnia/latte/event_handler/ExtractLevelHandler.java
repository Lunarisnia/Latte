package com.lounarisnia.latte.event_handler;

import com.lounarisnia.latte.LatteItems;
import com.lounarisnia.latte.MinigameManager;
import com.lounarisnia.latte.data.Minigame;
import com.lounarisnia.latte.data.MinigameRenderData;
import com.lounarisnia.latte.minigames.measuring_cup.MeasuringCupMinigame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ExtractLevelRenderStateEvent;

public class ExtractLevelHandler {
  @SubscribeEvent
  public void extractLevelState(ExtractLevelRenderStateEvent event) {
    Minigame minigame = MinigameManager.getActiveMinigame();
    if (minigame == null) {
      return;
    }
    // ClientLevel level = event.getLevel();
    // Player player = level.players().getFirst();

    MeasuringCupMinigame measuringCupMinigame = (MeasuringCupMinigame) minigame;

    // measuringCupMinigame.minigameRenderData = new MinigameRenderData(level,
    // event.getRenderState());
    var mc = Minecraft.getInstance();
    var level = event.getLevel();

    var stack = new ItemStack(LatteItems.COFFEE_PACKAGE_ITEM.get());
    var itemState = new ItemStackRenderState();

    mc.getItemModelResolver()
        .updateForTopItem(itemState, stack, ItemDisplayContext.FIXED, level, null, 0);

    Vec3 position = Vec3.atCenterOf(minigame.getStationPosition()).add(0.0, 0.5, 0.0);

    measuringCupMinigame.minigameRenderData = new MinigameRenderData(level, itemState, position);
  }
}
