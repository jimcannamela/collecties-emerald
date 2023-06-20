package com.galvanize.collecties;

public enum Biome {
  RAINFOREST,
  TAIGA,
  WOODLAND,
  SAVANNA,
  PLAINS,
  TUNDRA,
  DESERT,
  BOG,
  OCEANIC,
  BEACH,
  MOUNTAIN_RANGE,
  JUNGLE,
  SHADOW_DIMENSION,
  VOLCANIC;

  // Create a static array of all the Biomes
  private static final Biome[] biomesArray = Biome.values();

  /*
   * Use the biomes array to easily get a random Biome
   */
  public static Biome getRandomBiome() {
    return biomesArray[Game.randogen.nextInt(biomesArray.length)];
  }
}
