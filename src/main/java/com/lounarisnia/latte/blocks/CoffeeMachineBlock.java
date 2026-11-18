package com.lounarisnia.latte.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

// TODO: Draw the simple coffee machine
// TODO: Right clicking it gives coffee to the user
public class CoffeeMachineBlock extends Block {
	public CoffeeMachineBlock(Properties properties) {
		super(properties.sound(SoundType.ANVIL));
	}
}
