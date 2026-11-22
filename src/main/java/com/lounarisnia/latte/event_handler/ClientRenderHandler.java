package com.lounarisnia.latte.event_handler;

import com.lounarisnia.latte.MinigameManager;
import com.lounarisnia.latte.minigames.measuring_cup.MeasuringCupMinigame;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;

// TODO: Extract level handler and this properly render the coffee package on top of the cup
// But I don't like a couple things, first is that the implementation couples directly to
// MeasuringCupMinigame
// second is that it renders static item not the one the players is holding
public class ClientRenderHandler {
  @SubscribeEvent
  public void renderItem(RenderLevelStageEvent.AfterOpaqueBlocks event) {
    if (!(MinigameManager.getActiveMinigame() instanceof MeasuringCupMinigame cup)) {
      return;
    }

    var data = cup.minigameRenderData;
    if (data == null || data.item().isEmpty()) {
      return;
    }

    Vec3 cameraPosition = event.getLevelRenderState().cameraRenderState.pos;
    Vec3 relative = data.position().subtract(cameraPosition);

    PoseStack poses = new PoseStack();
    poses.translate(relative.x, relative.y, relative.z);

    data.item()
        .submit(
            poses,
            Minecraft.getInstance().gameRenderer.getSubmitNodeStorage(),
            LightTexture.FULL_BRIGHT,
            OverlayTexture.NO_OVERLAY,
            0);
  }
}
