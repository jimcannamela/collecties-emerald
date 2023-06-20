package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;

import java.util.ArrayList;

/*
 * This enum is used as a master list for all consumables
 * If the consumable is not set up here it will not be obtainable
 * during gameplay
 * Tracking consumable types this way is a bit cleaner than
 * alternatives for aggregating a list of all consumables
 * Basically creating a static map for all consumables here
 */
public enum Consumables {

  // Each element in this enum requires
  // a reference instance of the class
  // it represents
  // CONSUMABLE(new Consumable()) / KEY(VALUE)
  ENERGY_DRINK(new EnergyDrink()),
  ELIXIR(new Elixir()),
  PIZZA(new Pizza()),
  CEREAL(new Cereal()),
  COTTONCANDY(new CottonCandy()),
  KETCHUP_PACKET(new KetchupPacket()),
  RIBS(new Ribs()),
  SUBSANDWICH(new SubSandwich()),
  GUPPIES(new Guppies()),
  VEGANCHILI(new VeganChili()),
  GREENPOTION(new GreenPotion());

  // Create a static array of all the Consumables
  private static final Consumables[] consumablesArray = Consumables.values();

  /*
   * Use the consumables array to easily get a random consumable
   */
  public static Consumable getRandomConsumable(Biome currentBiome) {
    ArrayList<Consumable> biomeConsumable = new ArrayList<>();
    for (int i = 0; i < consumablesArray.length; i++) {
      if(consumablesArray[i].getReference().getContainingBiome() == currentBiome){
        biomeConsumable.add(consumablesArray[i].getReference());
      }
    }
    if(biomeConsumable.isEmpty()){
      return null;
    }
    return biomeConsumable.get(Game.randogen.nextInt(biomeConsumable.size()))
      .clone();
  }

  /*
   * Enums can actually have a constructor
   * and instance data/methods. In this case
   * we just need to keep a reference object
   * for the consumable each enum represents
   * This allows us to easy create clones of
   * those reference objects attached to each enum
   * Basically we are creating a static list for all
   * consumables
   */

  private final Consumable reference;

  Consumables(Consumable reference) {
    this.reference = reference;
  }

  public Consumable getReference() {
    return reference;
  }
}
