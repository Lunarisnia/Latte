package com.lounarisnia.latte.data;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.phys.Vec3;

public record MinigameRenderData(ClientLevel level, ItemStackRenderState item, Vec3 position) {}
