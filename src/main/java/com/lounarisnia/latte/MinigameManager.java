package com.lounarisnia.latte;

import com.lounarisnia.latte.data.Minigame;

public class MinigameManager {
  private static Minigame activeMinigame;

  public static void start(Minigame minigame) {
    activeMinigame = minigame;
  }

  public static Minigame getActiveMinigame() {
    return activeMinigame;
  }

  public static void stop() {
    activeMinigame = null;
  }
}
