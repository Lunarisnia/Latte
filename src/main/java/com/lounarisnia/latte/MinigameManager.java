package com.lounarisnia.latte;

import com.lounarisnia.latte.data.Minigame;
import com.lounarisnia.latte.data.MousePosition;

public class MinigameManager {
  private static Minigame activeMinigame;
  private static MousePosition mousePosition;

  public static void start(Minigame minigame) {
    activeMinigame = minigame;
  }

  public static Minigame getActiveMinigame() {
    return activeMinigame;
  }

  public static void stop() {
    activeMinigame = null;
  }

  public static void setMousePosition(double xpos, double ypos) {
    mousePosition = new MousePosition(xpos, ypos);
  }

  public static MousePosition getMousePosition() {
    return mousePosition;
  }
}
