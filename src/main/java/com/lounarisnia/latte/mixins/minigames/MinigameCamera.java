package com.lounarisnia.latte.mixins.minigames;

import com.lounarisnia.latte.MinigameManager;
import com.lounarisnia.latte.data.CameraView;
import com.lounarisnia.latte.data.Minigame;
import net.minecraft.client.Camera;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
abstract class MinigameCamera {
  @Shadow
  protected abstract void setPosition(double x, double y, double z);

  @Shadow
  protected abstract void setRotation(float yaw, float pitch);

  @Inject(method = "setup", at = @At("TAIL"))
  private void latte$applyFixedCamera(CallbackInfo ci) {
    Minigame activeMinigame = MinigameManager.getActiveMinigame();
    if (activeMinigame != null) {
      CameraView minigameCamera = activeMinigame.getCameraView();
      Vec3 position = minigameCamera.position();
      Vec2 rotation = minigameCamera.rotation();

      setPosition(position.x, position.y, position.z);
      setRotation(rotation.x, rotation.y);
    }
  }
}
