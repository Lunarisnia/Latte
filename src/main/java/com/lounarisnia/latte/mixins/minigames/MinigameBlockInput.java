package com.lounarisnia.latte.mixins.minigames;

import com.lounarisnia.latte.MinigameManager;
import net.minecraft.client.player.ClientInput;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.world.phys.Vec2;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardInput.class)
public class MinigameBlockInput extends ClientInput {

  @Inject(method = "tick", at = @At("TAIL"))
  private void latte$blockPlayerMovement(CallbackInfo ci) {
    if (MinigameManager.getActiveMinigame() != null) {
      this.moveVector = Vec2.ZERO;
    }
  }
}
