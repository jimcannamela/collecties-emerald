package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: Green Potion")
public class GreenPotionTests {
    GreenPotion greenPotion;

    @BeforeEach
    public void testSetup() {
        greenPotion = new GreenPotion();
    }

    @Test
    public void shouldHaveTheRightName() {
        assertEquals("Green Potion (2)", greenPotion.getName());
    }

    @Test
    public void shouldHave2DrinksToConsume() {
        assertFalse(greenPotion.consume());
        assertTrue(greenPotion.consume());
    }

    @Test
    public void shouldShowDrinkCountInName() {
        assertTrue(greenPotion.getName().contains("(2)"));
        greenPotion.consume();
        assertTrue(greenPotion.getName().contains("(1)"));
    }

    @Test
    public void shouldBeAbleReturnASpecificBiome() {
        Biome actual = greenPotion.getContainingBiome();
        assertEquals(Biome.VOLCANIC,actual);
    }
}

