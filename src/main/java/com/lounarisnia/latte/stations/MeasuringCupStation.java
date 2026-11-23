package com.lounarisnia.latte.stations;

import com.lounarisnia.latte.Latte;
import com.lounarisnia.latte.LatteBlocks;
import com.pockyl.diegesis.api.Diegesis;
import com.pockyl.diegesis.api.state.ControlSpec;
import com.pockyl.diegesis.api.state.StationSchema;
import com.pockyl.diegesis.api.station.StationType;
import net.minecraft.resources.Identifier;

// TODO: Should probably be combined with the scales
public class MeasuringCupStation {
  public static final Identifier ID = Identifier.fromNamespaceAndPath(Latte.MODID, "measuring_cup");

  public static StationType STATION_TYPE = type();

  private MeasuringCupStation() {}

  public static StationSchema schema() {
    return StationSchema.builder()
        .control("foobar", ControlSpec.stepped(-1.0f, 1.0f, 64, 0.0f))
        .build();
  }

  public static StationType type() {
    return Diegesis.station(ID)
        .block(LatteBlocks.MEASURING_CUP_BLOCK)
        .schema(schema())
        .hidesBlock()
        .build();
  }

  public static void register() {
    Diegesis.register(STATION_TYPE);
  }
}
