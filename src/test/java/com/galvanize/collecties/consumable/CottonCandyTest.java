package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: Cotton Candy")
class CottonCandyTest {

    CottonCandy cottonCandy;

    @BeforeEach
    public void testSetup() {cottonCandy = new CottonCandy();}
    @Test
    void shouldHaveTheRightName() {
        assertEquals("IronFang Pink Cotton Candy", cottonCandy.getName());
    }

    @Test
    void shouldBeConsumable() {
        assertTrue(cottonCandy.consume());
    }

    @Test
    void shouldCreateNewConsumable() {
        Consumable clone = cottonCandy.clone();
        assertNotEquals(clone, cottonCandy);
    }

    @Test
    public void shouldBeAbleReturnASpecificBiome() {
        Biome actual = cottonCandy.getContainingBiome();
        assertEquals(Biome.BOG,actual);
    }
}