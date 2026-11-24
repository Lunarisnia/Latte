package com.lounarisnia.latte.stations.scale;

import com.lounarisnia.latte.Latte;
import com.lounarisnia.latte.LatteBlocks;
import com.pockyl.diegesis.api.Diegesis;
import com.pockyl.diegesis.api.state.StationSchema;
import com.pockyl.diegesis.api.state.TankSpec;
import com.pockyl.diegesis.api.station.StationType;
import net.minecraft.resources.Identifier;

// TODO: set measuring cup to be placed on a slot instead
// TODO: allow taking the the cup with the amount of coffee bean still tracked inside the inventory
public class ScaleStation {
  public static final Identifier ID = Identifier.fromNamespaceAndPath(Latte.MODID, "scale");

  public static StationType STATION_TYPE = type();

  private ScaleStation() {}

  public static StationSchema schema() {
    return StationSchema.builder()
        .slots("bean_pack", 1)
        .tank("cup_receiver", TankSpec.of(30))
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
