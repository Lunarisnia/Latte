package com.lounarisnia.latte.datagen;

import com.lounarisnia.latte.Latte;
import com.lounarisnia.latte.LatteItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LatteLanguageProvider extends LanguageProvider {

  public LatteLanguageProvider(PackOutput output) {
    super(output, Latte.MODID, "en_us");
  }

  @Override
  protected void addTranslations() {
    add(LatteItems.CAFE_LATTE_ITEM.get(), "Cafe Latte");
    add(LatteItems.COFFEE_MACHINE_ITEM.get(), "Coffee Machine");
    add(LatteItems.COFFEE_BEAN_ITEM.get(), "Coffee Bean");
    add(LatteItems.MEASURING_CUP_ITEM.get(), "Measuring Cup");
    add(LatteItems.COFFEE_PACKAGE_ITEM.get(), "Coffee Package");
  }
}
