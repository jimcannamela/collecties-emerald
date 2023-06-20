package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Skelly")
public class SkelosaurTests {

    Skelosaur skelly;

    @BeforeEach
    public void testSetup() {
        skelly = new Skelosaur();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Scaresaur";
        skelly.setName(newName);
        assertEquals(newName, skelly.getName());
    }

    @Test
    public void shouldBeSkelosaurSpecies() {
        assertEquals("Skelosaur", skelly.getSpecies());
    }

    @Test
    public void shouldBeTypeFire() {
        Assertions.assertEquals(CollectieType.FIRE, skelly.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = skelly.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("SKEL SKEL", skelly.speak());
    }

    @Test
    public void shouldPreferVolcanicBiomes() {
        assertEquals(Biome.VOLCANIC, skelly.getPreferredBiome());
    }

    @Test
    public void shouldHaveZeroAttackPower() {
        assertEquals(13, skelly.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(skelly.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 450 && wins < 550);
    }

    @Test
    public void shouldGetNewSkelosaurOnClone() {
        Skelosaur clone = skelly.clone();
        assertNotEquals(clone, skelly);
    }
}
