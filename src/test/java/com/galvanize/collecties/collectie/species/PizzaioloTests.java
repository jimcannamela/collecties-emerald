package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import com.galvanize.collecties.consumable.Pizza;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Pete")
public class PizzaioloTests {
    Pizzaiolo pizzaiolo;

    @BeforeEach
    public void testSetup() {
        pizzaiolo = new Pizzaiolo();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Barb";
        pizzaiolo.setName(newName);
        assertEquals(newName, pizzaiolo.getName());
    }

    @Test
    public void shouldBeRextoreSpecies() {
        assertEquals("Pizzaiolo", pizzaiolo.getSpecies());
    }

    @Test
    public void shouldBeTypeDinosaur() {
        Assertions.assertEquals(CollectieType.GHOST, pizzaiolo.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = pizzaiolo.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("OOOOO0OOO0OOOOOO00000OOOOPE", pizzaiolo.speak());
    }

    @Test
    public void shouldPreferVolcanicBiomes() {
        assertEquals(Biome.SHADOW_DIMENSION, pizzaiolo.getPreferredBiome());
    }

    @Test
    public void shouldHave10AttackPower() {
        assertEquals(999999999, pizzaiolo.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(pizzaiolo.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 450 && wins < 550);
    }

    @Test
    public void shouldNewRextoreOnClone() {
        Pizzaiolo clone = pizzaiolo.clone();
        assertNotEquals(clone, pizzaiolo);
    }

    @Test
    public void getInfo() {
        assertEquals(pizzaiolo.getInfo(), "Pizzaiolo: An ethereal pizza-making chef, wielding a spectral pizza slicer to conjure doughy projections with deadly precision.");
    }
}
