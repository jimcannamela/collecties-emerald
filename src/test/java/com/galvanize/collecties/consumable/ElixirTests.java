package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElixirTests {
    
    private Elixir elixir;

    @BeforeEach
    void setUp() {
        elixir = new Elixir();
    }

    @Test
    void shouldHaveTheRightName() {
        assertEquals("Shark Elixir (3)", elixir.getName());
    }

    @Test
    void shouldHave3DosageToConsume() {
        assertFalse(elixir.consume());
        assertFalse(elixir.consume());
        assertTrue(elixir.consume());
    }

    @Test
    public void shouldBeAbleReturnASpecificBiome() {
        Biome actual = elixir.getContainingBiome();
        assertEquals(Biome.OCEANIC,actual);
    }
}
