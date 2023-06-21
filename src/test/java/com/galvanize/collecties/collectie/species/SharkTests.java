package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Shark")
public class SharkTests {
    Shark shark;

    @BeforeEach
    void setUp() {
        shark = new Shark();
    }

    @Test
    void shouldBeAbleToRename() {
        String newName = "Sharko";
        shark.setName(newName);
        assertEquals(newName, shark.getName());
    }

    @Test
    void shouldBeSharkSpecies() {
        assertEquals("Shark", shark.getSpecies());
    }

    @Test
    void shouldBeTypeAqua() {
        Assertions.assertEquals(CollectieType.AQUA, shark.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = shark.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("SHARRRK", shark.speak());
    }

    @Test
    void shouldPreferOceanicBiomes() {
        assertEquals(Biome.OCEANIC, shark.getPreferredBiome());
    }

    @Test
    void shouldHave100AttackPower(){
        assertEquals(100, shark.performAttack());
    }

    @Test
    void shouldSuccessfullyDefend50pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(shark.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 450 && wins < 550);
    }

    @Test
    public void shouldNewSharkOnClone() {
        Shark clone = shark.clone();
        assertNotEquals(clone, shark);
    }

    @Test
    public void getInfo() {
        assertEquals(shark.getInfo(), "Baby Shark, do do dodo do do, Baby Shark, do do dodo do do, Baby SHARK!");
    }
}
