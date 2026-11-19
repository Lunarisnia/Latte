package com.lounarisnia.latte.datagen;

import com.lounarisnia.latte.Latte;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Latte.MODID)
public class LatteModGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(LatteLanguageProvider::new);
        event.createProvider(LatteModelProvider::new);
    }
}
