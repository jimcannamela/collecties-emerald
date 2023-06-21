package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Collectie: Hobbes")
public class HobbesTest {

        Hobbes hobbes;

        @BeforeEach
        public void testSetup() {
            hobbes = new Hobbes();
        }

        @Test
        public void shouldBeAbleToRename() {
            String newName = "Hobbes";
            hobbes.setName(newName);
            assertEquals(newName, hobbes.getName());
        }
        @Test
        public void shouldBeHobbesSpecies() {
            assertEquals("Hobbes", hobbes.getSpecies());
        }
        @Test
        public void shouldBeTypeHobbes() {
            Assertions.assertEquals(CollectieType.HOMICIDAL_JUNGLE_CAT, hobbes.getType());
        }

        @Test
        public void shouldProvideAGraphic() {
            String graphic = hobbes.getGraphic();
            System.out.println(graphic);
            assertNotEquals(0, graphic.length());
        }

        @Test
        public void shouldHaveTheCorrectSound() {
            assertEquals("YUKON-HO", hobbes.speak());
        }
        @Test
        public void shouldPreferJungleBiomes() {
            assertEquals(Biome.JUNGLE, hobbes.getPreferredBiome());
        }
//
        @Test
        public void shouldHaveTwentyOneAttackPower() {
            assertEquals(21, hobbes.performAttack());
        }

        @Test
        public void shouldSuccessfullyDefend50pOfTheTime() {
            int wins = 0;
            for (int i = 0; i < 1000; i++) {
                if (hobbes.defend(0)) wins++;
            }
            System.out.println("Wins: " + wins);
            assertTrue(wins > 450 && wins < 550);
        }

        @Test
        public void shouldGetNewHobbesOnClone() {
            Hobbes clone = hobbes.clone();
            assertNotEquals(clone, hobbes);
        }

    @Test
    public void getInfo() {
        assertEquals(hobbes.getInfo(), "Hobbes: A charismatic and agile combatant, bringing the mischievous yet loyal nature of a true friend into battle.");
    }

}
