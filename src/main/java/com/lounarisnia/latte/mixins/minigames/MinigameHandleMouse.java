package com.lounarisnia.latte.mixins.minigames;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.lounarisnia.latte.MinigameManager;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MouseHandler.class)
public abstract class MinigameHandleMouse {

  @Shadow
  public abstract double xpos();

  @Shadow
  public abstract double ypos();

  @WrapOperation(
      method = "turnPlayer",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;turn(DD)V"))
  private void latte$blockTurning(
      LocalPlayer instance, double yaw, double pitch, Operation<Void> original) {
    if (MinigameManager.getActiveMinigame() != null) {
      // Latte.LOGGER.debug("Mouse Position: {}:{}", xpos(), ypos());
      MinigameManager.setMousePosition(xpos(), ypos());
      return;
    }

    original.call(instance, yaw, pitch);
  }
}
