package com.lounarisnia.latte.minigames.measuring_cup;

import com.lounarisnia.latte.data.CameraView;
import com.lounarisnia.latte.data.Minigame;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public final class MeasuringCupMinigame implements Minigame {
  private final BlockPos target;

  public MeasuringCupMinigame(BlockPos target) {
    this.target = target.immutable();
  }

  @Override
  public CameraView getCameraView() {
    Vec3 position = new Vec3(target.getX() + 0.5, target.getY() + 1.3, target.getZ() - 1.0);
    Vec2 rotation = new Vec2(0.0f, 35.0f);
    return new CameraView(position, rotation);
  }
}
