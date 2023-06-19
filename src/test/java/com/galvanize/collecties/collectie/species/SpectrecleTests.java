package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Collectie: Spectrecle")
public class SpectrecleTests {
    Spectrecle specs;

    @BeforeEach
    public void testSetup() {
        specs = new Spectrecle();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "George";
        specs.setName(newName);
        assertEquals(newName, specs.getName());
    }

    @Test
    public void shouldBeSpectrecleSpecies() {
        assertEquals("Spectrecle", specs.getSpecies());
    }

    @Test
    public void shouldBeTypeGhost() {
        Assertions.assertEquals(CollectieType.GHOST, specs.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = specs.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("BOOOOOOO", specs.speak());
    }

    @Test
    public void shouldPreferBogBiomes() {
        assertEquals(Biome.BOG, specs.getPreferredBiome());
    }

    @Test
    public void shouldHave5AttackPower() {
        assertEquals(5, specs.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(specs.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 283 && wins < 383);
    }

    @Test
    public void shouldNewSpectrecleOnClone() {
        Spectrecle clone = specs.clone();
        assertNotEquals(clone, specs);
    }
}
