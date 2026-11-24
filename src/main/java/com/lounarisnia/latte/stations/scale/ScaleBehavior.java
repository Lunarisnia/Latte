package com.lounarisnia.latte.stations.scale;

import com.lounarisnia.latte.Latte;
import com.pockyl.diegesis.api.client.StationBehavior;
import com.pockyl.diegesis.api.client.StationView;
import com.pockyl.diegesis.api.event.SceneEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

public final class ScaleBehavior implements StationBehavior {
  private final Vector3f offset = new Vector3f();

  public ScaleBehavior(StationView stationView) {}

  @Override
  public void onSceneReady(StationView view) {
    offset.zero();
  }

  private float tiltTime = -1;

  // FIXME: if you place bean pack then swap it with something else, you can pour it
  @Override
  public void onEvent(StationView view, SceneEvent event) {
    if (event instanceof SceneEvent.Click click && "bean_pack_action".equals(click.node())) {
      if (click.button() == GLFW.GLFW_MOUSE_BUTTON_2) {
        view.node("bean_pack").ifPresent(beanPack -> beanPack.rotateTo(0.0f, 0.0f, -50.0f, 0.1f));
        tiltTime = 0.0f;
      } else if (click.button() == GLFW.GLFW_MOUSE_BUTTON_1) {
        view.node("bean_pack_action").ifPresent(beanPackAction -> beanPackAction.setVisible(false));
        view.sendAction("take_bean_pack", new CompoundTag());
      }
      return;
    }
  }

  // TODO: Bean dropping physics, particle won't work, needs manual simulation
  @Override
  public void frame(StationView view, float deltaSeconds) {
    if (tiltTime < 0.0f) {
      return;
    }

    tiltTime += deltaSeconds;
    if (tiltTime >= 0.1f) {
      view.node("bean_pack")
          .ifPresent(
              beanPack -> {
                view.sendAction("pour_bean", new CompoundTag());
                beanPack.rotateTo(0.0f, 0.0f, -30.0f, 0.2f);
              });
      tiltTime = -1;
    }
  }

  @Override
  public void onEffect(StationView view, Identifier effect, String node, CompoundTag data) {
    if (effect.equals(Identifier.fromNamespaceAndPath(Latte.MODID, "shake"))) {
      view.node("bean_pack").ifPresent(beanPack -> beanPack.shake(0.5f, 0.3f));
    }

    // NOTE: either we use specific event name and make sure nothing shares it or check for the item
    // inside here to make sure it is correct
    if (effect.equals(Identifier.fromNamespaceAndPath(Latte.MODID, "tilt"))) {
      view.node("bean_pack").ifPresent(beanPack -> beanPack.rotateTo(0.0f, 0.0f, -30.0f, 0.2f));
      view.node("bean_pack_action").ifPresent(nodeView -> nodeView.setVisible(true));
    }
  }
}
