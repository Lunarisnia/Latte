package com.lounarisnia.latte.datagen;

import com.lounarisnia.latte.Latte;
import com.lounarisnia.latte.LatteBlocks;
import com.lounarisnia.latte.LatteItems;
import com.lounarisnia.latte.machines.CoffeeMachineBlock;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

public class LatteModelProvider extends ModelProvider {

  public LatteModelProvider(PackOutput output) {
    super(output, Latte.MODID);
  }

  @Override
  protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
    Block coffeeMachineBlock = LatteBlocks.COFFEE_MACHINE_BLOCK.get();

    Variant coffeeMachineVariant = new Variant(this.modLocation("block/coffee_machine_block"));
    Variant coffeeMachineWithPortaFilterVariant =
        new Variant(this.modLocation("block/coffee_machine_porta_filter_on_block"));

    blockModels.blockStateOutput.accept(
        MultiVariantGenerator.dispatch(coffeeMachineBlock)
            .with(
                PropertyDispatch.initial(CoffeeMachineBlock.PORTA_FILTER)
                    .select(false, BlockModelGenerators.variant(coffeeMachineVariant))
                    .select(
                        true, BlockModelGenerators.variant(coffeeMachineWithPortaFilterVariant))));

    Block measuringCupBlock = LatteBlocks.MEASURING_CUP_BLOCK.get();
    Variant measuringCupVariant = new Variant(this.modLocation("block/measuring_cup_block"));

    blockModels.blockStateOutput.accept(
        MultiVariantGenerator.dispatch(
            measuringCupBlock, BlockModelGenerators.variant(measuringCupVariant)));

    Block scaleBlock = LatteBlocks.SCALE_BLOCK.get();
    Variant scaleVariant = new Variant(this.modLocation("diegesis/scale/scale_body"));

    blockModels.blockStateOutput.accept(
        MultiVariantGenerator.dispatch(scaleBlock, BlockModelGenerators.variant(scaleVariant)));

    itemModels.generateFlatItem(LatteItems.CAFE_LATTE_ITEM.get(), ModelTemplates.FLAT_ITEM);

    itemModels.generateFlatItem(LatteItems.COFFEE_BEAN_ITEM.get(), ModelTemplates.FLAT_ITEM);

    blockModels.registerSimpleItemModel(
        LatteItems.COFFEE_PACKAGE_ITEM.get(), this.modLocation("diegesis/coffee_package"));

    blockModels.registerSimpleItemModel(
        LatteItems.MEASURING_CUP_ITEM.get(), this.modLocation("block/measuring_cup_block"));

    blockModels.registerSimpleItemModel(
        LatteItems.SCALE_BLOCK_ITEM.get(), this.modLocation("diegesis/scale/scale_body"));
  }
}
