package com.lounarisnia.latte.minigames.measuring_cup;

import com.lounarisnia.latte.data.CameraView;
import com.lounarisnia.latte.data.Minigame;
import com.lounarisnia.latte.data.MinigameRenderData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public final class MeasuringCupMinigame implements Minigame {
  private final BlockPos target;
  public MinigameRenderData minigameRenderData;

  public MeasuringCupMinigame(BlockPos target) {
    this.target = target.immutable();
  }

  @Override
  public CameraView getCameraView() {
    Vec3 position = new Vec3(target.getX() + 0.5, target.getY() + 1.3, target.getZ() - 1.0);
    Vec2 rotation = new Vec2(0.0f, 35.0f);
    return new CameraView(position, rotation);
  }

  @Override
  public Vec3i getStationPosition() {
    return new Vec3i(target.getX(), target.getY(), target.getZ());
  }
}
