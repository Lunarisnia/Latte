package com.lounarisnia.latte;

import com.lounarisnia.latte.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LatteTab {
	public static final DeferredRegister<CreativeModeTab> LATTE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Latte.MODID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> LATTE_TAB_HOLDER =
			LATTE_TAB.register("latte_tab", () -> CreativeModeTab.builder()
					.title(Component.literal("Latte"))
					.icon(Items.STONE::getDefaultInstance)
					.displayItems(((itemDisplayParameters, output) ->
							output.accept(ModItems.CAFE_LATTE_ITEM)
					))
					.build()
			);

	public static void register(IEventBus modEventBus) {
		LATTE_TAB.register(modEventBus);
	}
}
