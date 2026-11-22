package com.lounarisnia.latte.event_handler;

import com.lounarisnia.latte.MinigameManager;
import com.lounarisnia.latte.data.Minigame;
import net.minecraft.world.InteractionHand;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderHandEvent;

public class RenderHandHandler {
  @SubscribeEvent
  public void onRenderHand(RenderHandEvent event) {
    if (event.getHand() != InteractionHand.MAIN_HAND) {
      return;
    }

    Minigame minigame = MinigameManager.getActiveMinigame();
    if (minigame == null) {
      return;
    }

    event.setCanceled(true);
  }
}
