package com.lounarisnia.latte;

import com.mojang.serialization.Codec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public final class ModAttachments {
	private ModAttachments() {
	}

	private static final DeferredRegister<AttachmentType<?>> ATTACHMENTS =
			DeferredRegister.create(
					NeoForgeRegistries.ATTACHMENT_TYPES,
					Latte.MODID
			);

	public static final Supplier<AttachmentType<Integer>> DRINK_COUNT =
			ATTACHMENTS.register("drink_count", () ->
					AttachmentType.builder(() -> 0)
							.serialize(Codec.INT.fieldOf("count"))
							.build()
			);

	public static void register(IEventBus modEventBus) {
		ATTACHMENTS.register(modEventBus);
	}
}