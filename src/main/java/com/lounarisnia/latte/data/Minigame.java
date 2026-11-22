package com.lounarisnia.latte.data;

import net.minecraft.core.Vec3i;

public interface Minigame {
  CameraView getCameraView();

  Vec3i getStationPosition();
}
