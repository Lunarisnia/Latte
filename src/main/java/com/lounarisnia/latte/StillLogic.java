package com.lounarisnia.latte;

import com.pockyl.diegesis.api.client.DiegesisParticles;
import com.pockyl.diegesis.api.station.StationContext;
import com.pockyl.diegesis.api.station.StationLogic;
import net.minecraft.world.entity.player.Player;

final class StillLogic implements StationLogic {
  StillLogic(StationContext station) {}

  @Override
  public void onControlChanged(StationContext station, Player player, String control, float value) {
    if (value > 0.9F) {
      station.effect(DiegesisParticles.STEAM, "input"); // everyone around sees the steam
    }
  }
}
