package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

/*
 * The consumable interface just makes sure all consumables
 * have a name, can be consumed, and can be cloned
 */
public interface Consumable {
  String getName();
  boolean consume();
  Consumable clone();
  Biome getContainingBiome();
  default int hpRecovered() {return 0;}
  //if isRevivalItem is set to true, using the item on a
  //Collectie who is unconscious will revive them
  default boolean isRevivalItem(){
    return false;
  }
}
