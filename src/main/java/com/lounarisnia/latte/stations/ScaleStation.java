package com.lounarisnia.latte.stations;

import com.lounarisnia.latte.Latte;
import com.lounarisnia.latte.LatteBlocks;
import com.pockyl.diegesis.api.Diegesis;
import com.pockyl.diegesis.api.state.ControlSpec;
import com.pockyl.diegesis.api.state.StationSchema;
import com.pockyl.diegesis.api.station.StationType;
import net.minecraft.resources.Identifier;

// TODO: Should probably be combined with the scales
public class ScaleStation {
  public static final Identifier ID = Identifier.fromNamespaceAndPath(Latte.MODID, "scale");

  public static StationType STATION_TYPE = type();

  private ScaleStation() {}

  public static StationSchema schema() {
    return StationSchema.builder()
        .slots("bean_pack", 1)
        .control("foobar", ControlSpec.stepped(-1.0f, 1.0f, 64, 0.0f))
        .build();
  }

  public static StationType type() {
    return Diegesis.station(ID)
        .block(LatteBlocks.SCALE_BLOCK)
        .schema(schema())
        .logic(ScaleLogic::new)
        .build();
  }

  public static void register() {
    Diegesis.register(STATION_TYPE);
  }
}
