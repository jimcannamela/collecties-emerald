package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Bunz")
public class BunzTests {

    Bunz testDog;
    @BeforeEach
    public void setup() {
        testDog = new Bunz();
    }

    @Test
    public void testSetGetName(){
        testDog.setName("hotdiggitydog");

        String expected = "hotdiggitydog";
        String actual = testDog.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeBunzSpecies() {
        assertEquals("Bunz", testDog.getSpecies());
    }

    @Test
    public void shouldBeTypeSnack() {
        Assertions.assertEquals(CollectieType.SNACK, testDog.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = testDog.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("NO SAUERKRAUT", testDog.speak());
    }

    @Test
    public void shouldPreferVolcanicBiomes() {
        assertEquals(Biome.BEACH, testDog.getPreferredBiome());
    }

    @Test
    public void shouldHave10AttackPower() {
        assertEquals(10, testDog.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(testDog.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 450 && wins < 550);
    }

    @Test
    public void shouldNewBunzOnClone() {
        Bunz clone = testDog.clone();
        assertNotEquals(clone, testDog);
    }
}
