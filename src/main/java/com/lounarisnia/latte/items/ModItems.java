package com.lounarisnia.latte.items;

import com.lounarisnia.latte.Latte;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Latte.MODID);

	public static final DeferredItem<CafeLatteItem> CAFE_LATTE_ITEM =
			ITEMS.registerItem("cafe_latte", CafeLatteItem::new);

	public static void register(IEventBus modEventBus) {
		ITEMS.register(modEventBus);
	}
}
