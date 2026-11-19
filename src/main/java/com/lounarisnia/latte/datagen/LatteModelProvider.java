package com.lounarisnia.latte.datagen;

import com.lounarisnia.latte.Latte;
import com.lounarisnia.latte.blocks.ModBlocks;
import com.lounarisnia.latte.items.ModItems;
import java.util.stream.Stream;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.data.PackOutput;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class LatteModelProvider extends ModelProvider {

    public LatteModelProvider(PackOutput output) {
        super(output, Latte.MODID);
    }

    // @Override
    // protected Stream<? extends Holder<Item>> getKnownItems() {
    //     return Stream.of(ModItems.COFFEE_MACHINE_ITEM);
    // }

    @Override
    protected void registerModels(
        BlockModelGenerators blockModels,
        ItemModelGenerators itemModels
    ) {
        Block coffeeMachineBlock = ModBlocks.COFFEE_MACHINE_BLOCK.get();

        Variant coffeeMachineVariant = new Variant(
            this.modLocation("block/coffee_machine_block")
        );

        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(
                coffeeMachineBlock,
                BlockModelGenerators.variants(coffeeMachineVariant)
            )
        );


        itemModels.generateFlatItem(ModItems.CAFE_LATTE_ITEM.get(), ModelTemplates.FLAT_ITEM);
    }
}
