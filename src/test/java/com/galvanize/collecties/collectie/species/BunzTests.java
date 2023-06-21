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
    public void testGetSpecies() {
        assertEquals("Bunz", testDog.getSpecies());
    }

    @Test
    public void testGetType() {
        Assertions.assertEquals(CollectieType.SNACK, testDog.getType());
    }

    @Test
    public void testGetGraphic() {
        String graphic = testDog.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void testSpeak() {
        assertEquals("NO SAUERKRAUT", testDog.speak());
    }

    @Test
    public void testGetPreferredBiome() {
        assertEquals(Biome.BEACH, testDog.getPreferredBiome());
    }

    @Test
    public void testPerformAttack_TwoAttackPower() {
        assertEquals(2, testDog.performAttack());
    }

    @Test
    public void testDefend_SuccessfullyDefend80PercentOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(testDog.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 750 && wins < 900);
    }

    @Test
    public void testClone_CreateNewInstanceOfBunz() {
        Bunz clone = testDog.clone();
        assertNotEquals(clone, testDog);
    }

    @Test
    public void getInfo() {
        assertEquals(testDog.getInfo(), "Bunz: A fiery and fearsome entity, embodying the essence of a hotdog with a passion for highly-processed meat-based combat");
    }
}
