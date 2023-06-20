package com.galvanize.collecties.consumable;

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
        assertEquals("Recovers 100% health from Shark Attacks. Remaining usage (3)", elixir.getName());
    }

    @Test
    void shouldHave3DosageToConsume() {
        assertFalse(elixir.consume());
        assertFalse(elixir.consume());
        assertTrue(elixir.consume());
    }
}
