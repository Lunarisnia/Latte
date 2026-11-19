package com.lounarisnia.latte.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

// TODO: Right clicking it gives coffee to the user
public class CoffeeMachineBlock extends Block {
	public CoffeeMachineBlock(Properties properties) {
		super(properties.sound(SoundType.ANVIL).noOcclusion());
	}
}
