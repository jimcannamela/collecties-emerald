package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Consumables Enum")
public class ConsumablesTests {

  @Test
  public void shouldBeAbleToGetRandomConsumable() {
    Consumable consumable = Consumables.getRandomConsumable(Biome.BOG);
    assertNotNull(consumable);
  }

  @Test
  public void shouldReturnNullIfNoValidBiomes() {
    Consumable consumable = Consumables.getRandomConsumable(Biome.DESERT);
    assertNull(consumable);
  }


}
