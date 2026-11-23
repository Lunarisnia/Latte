package com.lounarisnia.latte.stations;

import com.lounarisnia.latte.Latte;
import com.pockyl.diegesis.api.client.StationBehavior;
import com.pockyl.diegesis.api.client.StationView;
import com.pockyl.diegesis.api.event.SceneEvent;
import net.minecraft.world.item.ItemStack;
import org.joml.Vector3f;

// TODO: experiment more into this interface
// TODO: try using the grabbable type
public final class MeasuringCupBehavior implements StationBehavior {
  private final Vector3f offset = new Vector3f();
  private final Vector3f lastPoint = new Vector3f();

  public MeasuringCupBehavior(StationView stationView) {}

  @Override
  public void onSceneReady(StationView view) {
    offset.zero();
  }

  @Override
  public boolean onItemClick(
      StationView view, String node, ItemStack stack, int button, boolean shift) {
    return StationBehavior.super.onItemClick(view, node, stack, button, shift);
  }

  @Override
  public void onEvent(StationView view, SceneEvent event) {
    if (event instanceof SceneEvent.Click click && click.node().equals("measuring_cup")) {
      Latte.LOGGER.debug("CLICKED");
    }
    // if (!(event instanceof SceneEvent.Stroke stroke)
    //     || !"measuring_cup".equals(stroke.node())
    //     || stroke.button() != GLFW.GLFW_MOUSE_BUTTON_LEFT) {
    //   return;
    // }

    // if (stroke.phase() == SceneEvent.Stroke.Phase.START) {
    //   lastPoint.set(stroke.point());
    // } else if (stroke.phase() == SceneEvent.Stroke.Phase.MOVE) {
    //   offset.add(new Vector3f(stroke.point()).sub(lastPoint));
    //   lastPoint.set(stroke.point());
    //   view.node("measuring_cup")
    //       .ifPresent(
    //           node -> {
    //             node.moveTo(offset.x, offset.y, offset.z, 0);
    //           });
    // }
  }
}
