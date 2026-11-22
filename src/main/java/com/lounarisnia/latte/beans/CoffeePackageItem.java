package com.lounarisnia.latte.beans;

import net.minecraft.world.item.Item;

public class CoffeePackageItem extends Item {
  public CoffeePackageItem(Properties properties) {
    super(properties.stacksTo(1));
  }
}
