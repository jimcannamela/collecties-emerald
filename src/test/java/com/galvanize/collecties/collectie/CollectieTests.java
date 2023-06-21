package com.galvanize.collecties.collectie;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie Base Class")
public class CollectieTests {

  @Test
  public void shouldBeAbleToGetRandomCollectieFromBiome() {
    Collectie randomCollectie = Collectie.getRandomCollectieForBiome(Biome.PLAINS);
    assertEquals(Biome.PLAINS, randomCollectie.getPreferredBiome());
  }

  @Test
  public void shouldBeAbleToGetABiomeWithCollectiesAssignedToIt() {
    Biome randomBiome = Collectie.getRandomNonEmptyBiome();
    assertNotEquals(0, Collectie.speciesByBiomeReference.get(randomBiome).size());
  }
  @Test
  public void shouldCheckIfHealthIsZero() {
    assertTrue(Collectie.isHealthZero());
  }

  @Test
  public void shouldSubtractHealth() {
    assertTrue(Collectie.subtractHealth(1));

  }


}
