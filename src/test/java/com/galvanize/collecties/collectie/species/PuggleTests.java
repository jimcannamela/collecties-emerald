package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Collectie: Puggle")
public class PuggleTests {
    Puggle pug;

    @BeforeEach
    public void testSetup() {
        pug = new Puggle();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Mr. Pug";
        pug.setName(newName);
        assertEquals(newName, pug.getName());
    }

    @Test
    public void shouldBePuggleSpecies() {
        assertEquals("Puggle", pug.getSpecies());
    }

    @Test
    public void shouldBeTypeElemental() {
        Assertions.assertEquals(CollectieType.ELEMENTAL, pug.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = pug.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("BARK", pug.speak());
    }

    @Test
    public void shouldPreferBeachBiomes() {
        assertEquals(Biome.BEACH, pug.getPreferredBiome());
    }

    @Test
    public void shouldHave7AttackPower() {
        assertEquals(7, pug.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend67pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(pug.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 616 && wins < 716);
    }
    @Test
    public void shouldAlwaysWinIfOpponentAttackIs10() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(pug.defend(10)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins == 1000);
    }

    @Test
    public void shouldNewPuggleOnClone() {
        Puggle clone = pug.clone();
        assertNotEquals(clone, pug);
    }
}
