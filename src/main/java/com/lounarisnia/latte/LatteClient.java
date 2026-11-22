package com.lounarisnia.latte;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.lwjgl.glfw.GLFW;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = Latte.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class
// annotated with @SubscribeEvent
@EventBusSubscriber(modid = Latte.MODID, value = Dist.CLIENT)
public class LatteClient {
  private static final KeyMapping EXIT_MINIGAME =
      new KeyMapping("key.latte.exit_minigame", GLFW.GLFW_KEY_G, KeyMapping.Category.MISC);

  public LatteClient(ModContainer container) {
    // Allows NeoForge to create a config screen for this mod's configs.
    // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking
    // on config.
    // Do not forget to add translations for your config options to the en_us.json file.
    container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
  }

  @SubscribeEvent
  public static void registerBindings(RegisterKeyMappingsEvent event) {
    event.register(EXIT_MINIGAME);
  }

  @SubscribeEvent
  public static void onClientTick(ClientTickEvent.Post event) {
    while (EXIT_MINIGAME.consumeClick()) {
      MinigameManager.stop();
    }
  }

  @SubscribeEvent
  static void onClientSetup(FMLClientSetupEvent event) {
    // Some client setup code
    Latte.LOGGER.info("HELLO FROM CLIENT SETUP");
    Latte.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
  }
}
