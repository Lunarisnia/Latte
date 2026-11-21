package com.lounarisnia.latte.datagen;

import com.lounarisnia.latte.Latte;
import com.lounarisnia.latte.items.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LatteLanguageProvider extends LanguageProvider {

    public LatteLanguageProvider(PackOutput output) {
        super(output, Latte.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.CAFE_LATTE_ITEM.get(), "Cafe Latte");
        add(ModItems.COFFEE_MACHINE_ITEM.get(), "Coffee Machine");
        add(ModItems.COFFEE_BEAN_ITEM.get(), "Coffee Bean");
    }
}
