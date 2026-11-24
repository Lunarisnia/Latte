package com.lounarisnia.latte;

import com.lounarisnia.latte.gametest.CoffeeMachineTests;
import com.lounarisnia.latte.stations.ScaleStation;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Latte.MODID)
public class Latte {
  // Define mod id in a common place for everything to reference
  public static final String MODID = "latte";
  // Directly reference a slf4j logger
  public static final Logger LOGGER = LogUtils.getLogger();

  // The constructor for the mod class is the first code that is run when your mod is loaded.
  // FML will recognize some parameter types like IEventBus or ModContainer and pass them in
  // automatically.
  public Latte(IEventBus modEventBus, ModContainer modContainer) {
    // Register the commonSetup method for modloading
    modEventBus.addListener(this::commonSetup);

    ModAttachments.register(modEventBus);
    LatteBlocks.register(modEventBus);
    LatteBlockEntities.register(modEventBus);
    CoffeeMachineTests.register(modEventBus);
    LatteItems.register(modEventBus);
    // Register the Deferred Register to the mod event bus so tabs get registered
    LatteTab.register(modEventBus);
    ScaleStation.register();

    // Register ourselves for server and other game events we are interested in.
    // Note that this is necessary if and only if we want *this* class (Latte) to respond directly
    // to events.
    // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like
    // onServerStarting() below.
    NeoForge.EVENT_BUS.register(this);
    // NeoForge.EVENT_BUS.register(new RenderHandHandler());
    // NeoForge.EVENT_BUS.register(new ExtractLevelHandler());
    // NeoForge.EVENT_BUS.register(new ClientRenderHandler());

    // Register our mod's ModConfigSpec so that FML can create and load the config file for us
    modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(FMLCommonSetupEvent event) {
    // Some common setup code
    LOGGER.info("HELLO FROM COMMON SETUP");

    if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
      LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
    }

    LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

    Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
  }

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {
    LOGGER.info("HELLO from server starting");
  }
}
