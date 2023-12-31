package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Consumable: Ribs")
public class RibsTests {
    Ribs ribs;

    @BeforeEach
    public void testSetup() {
        ribs = new Ribs();
    }

    @Test
    public void shouldHaveTheRightName() {
        assertEquals("Rack of Dodud ribs (7)", ribs.getName());
    }

    @Test
    public void shouldHave7RibsToConsume() {
        assertFalse(ribs.consume());
        assertFalse(ribs.consume());
        assertFalse(ribs.consume());
        assertFalse(ribs.consume());
        assertFalse(ribs.consume());
        assertFalse(ribs.consume());
        assertTrue(ribs.consume());
    }

    @Test
    public void shouldShowRibCountInName() {
        assertTrue(ribs.getName().contains("(7)"));
        ribs.consume();
        assertTrue(ribs.getName().contains("(6)"));
    }

    @Test
    public void shouldBeAbleReturnASpecificBiome() {
        Biome actual = ribs.getContainingBiome();
        assertEquals(Biome.TAIGA,actual);
    }
}
