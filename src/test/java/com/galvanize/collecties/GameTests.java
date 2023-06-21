package com.galvanize.collecties;

import com.galvanize.collecties.collectie.Collectie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.galvanize.collecties.GameHelper.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTests {

    @BeforeAll
    public static void setupOnce() {
        Collectie.buildSpeciesBiomeMap();
    }

    @BeforeEach
    public void setup() {
    }

    @Test
    public void canExitGame() {
        String input = "n\n5\n";
        disableGameSleep();
        String output = runGameWithInput(input);
        enableGameSleep();
        System.out.println(output);
        displayOutputLines(output);
        Assertions.assertEquals("?: Thank you for playing!", output.split("\\r?\\n")[14]);
    }

    @Test
    public void showCollectionThenExit() {
        List<String> gameInput = new ArrayList<>(Arrays.asList("n", "3", "1", "6", "5"));
        String output = runGameWithInput(gameInput);
        System.out.println(output);
        Assertions.assertTrue(output.contains("Collectie Collection"));
    }

    @Test
    public void getCollectidexMenuOnce(){
        List<String> gameInput = new ArrayList<>(Arrays.asList("n", "4", "1", "n", "5"));
        String output = runGameWithInput(gameInput);
        System.out.println(output);
        Assertions.assertTrue(output.contains("Rextore: A Jurrasic era reincarnation, he enjoys long walks on the beach with Mrs. Rextore after a bountiful feast of Dodud filets"));
    }

    @Test
    public void getCollectidexMenuMultiple(){
        List<String> gameInput = new ArrayList<>(Arrays.asList("n", "4", "1", "y", "3", "n", "5"));
        String output = runGameWithInput(gameInput);
        System.out.println(output);
        Assertions.assertTrue(output.contains("Rextore: A Jurrasic era reincarnation, he enjoys long walks on the beach with Mrs. Rextore after a bountiful feast of Dodud filets"));
        Assertions.assertTrue(output.contains("Dodud: A quirky and delicious creature with an tasty disposition, skilled at releasing methane gas into the upper stratosphere."));
    }

    @Test
    public void showNoConsumablesOnGameStartThenExit() {
        String output = runGameWithInput("n", "3", "2", "6", "5");
        System.out.println(output);
        Assertions.assertTrue(output.contains("No consumables available"));
    }

    @Test
    public void canRenameCollectie() {
        String output = runGameWithInput("n", "3", "4", "1", "Rexter", "y", "1", "6", "5");
        displayOutputLines(output);
        Assertions.assertEquals("[1] Rexter (Rextore) ", output.split("\\r?\\n")[35]);
    }

    @Test
    public void canRenameCollectieNotHappyWithName() {
        String output = runGameWithInput("n", "3", "4", "1", "Rexter", "n", "Rexy", "y", "1", "6", "5");
        displayOutputLines(output);
        Assertions.assertEquals("[1] Rexy (Rextore) ", output.split("\\r?\\n")[38]);
    }

    @Test
    public void attemptToFeedCollectieWithNoConsumables() {
        String output = runGameWithInput("y", "Rextor", "y", "3", "3", "1", "6", "5");
        displayOutputLines(output);
        Assertions.assertEquals("?: You have no consumables to feed Rextor!", output.split("\\r?\\n")[27]);
    }

    @Test
    public void collectConsumable() {
        // 4 - PLAINS is picked as BIOME
        //     This BIOME has to be one with a Collectie in it on Game start
        // 10001 - Random number given to first Collectie
        // 51 - Exploring goes to findConsumable logic
        // 0 - Finds first Consumable in this BIOME
        List<Integer> numberSequence = new ArrayList<>(Arrays.asList(4, 10001, 51, 0));
        hookIntoRandom(numberSequence);
        disableGameSleep();
        String output = runGameWithInput("n", "2", "5");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("You found a Rextore Claws Energy Drink while exploring.", output.split("\\r?\\n")[15]);
    }

    @Test
    public void fightCollectieAndWin() {
        // 11 - VOLCANIC is picked as BIOME
        // 10001 - Random number given to first Collectie
        // 1 - Exploring goes to encounter logic
        // 0 - Finds first Collectie in this BIOME
        // 10002 - Random number given to cloned Collectie
        // 11 - Roll below 50 for Rextor to win
        hookIntoRandom(11, 10001, 1, 0, 10002, 11);
        disableGameSleep();
        String output = runGameWithInput("n", "2", "1", "n", "5");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("Would you like to capture the wild Rextore?", output.split("\\r?\\n")[51]);
    }

    @Test
    public void bothMiss() {
        // 11 - VOLCANIC is picked as BIOME
        // 10001 - Random number given to first Collectie
        // 1 - Exploring goes to encounter logic
        // 0 - Finds first Collectie in this BIOME
        // 10002 - Random number given to cloned Collectie
        // 51 - our Rextore misses
        // 51 - other Rextore misses
        hookIntoRandom(11, 10001, 1, 0, 10002, 51, 51);
        disableGameSleep();
        String output = runGameWithInput("n", "2", "1", "5");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("The wild Rextore manages to survive the blow!", output.split("\\r?\\n")[50]);
        Assertions.assertEquals("Rextore 10001 survives the blow!", output.split("\\r?\\n")[53]);
    }

    @Test
    public void fightWithMissThenGetHit() {
        // 11 - VOLCANIC is picked as BIOME
        // 10001 - Random number given to first Collectie
        // 1 - Exploring goes to encounter logic
        // 0 - Finds first Collectie in this BIOME
        // 10002 - Random number given to cloned Collectie
        // 51 - our Rextore misses
        // 1 - other Rextore hits
        hookIntoRandom(11, 10001, 1, 0, 10002, 51, 1);
        disableGameSleep();
        String output = runGameWithInput("n", "2", "1","3","1","6","5");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("The wild Rextore manages to survive the blow!", output.split("\\r?\\n")[50]);
        Assertions.assertEquals("Rextore 10001 has fallen and is unconscious!", output.split("\\r?\\n")[53]);
        Assertions.assertEquals("[1] Rextore 10001 (Rextore) [UNCONSCIOUS]", output.split("\\r?\\n")[69]);
    }
    @Test
    public void fightWhileProtectorUnconsciousRuns(){
        // 11 - VOLCANIC is picked as BIOME
        // 10001 - Random number given to first Collectie
        // 1 - Exploring goes to encounter logic
        // 0 - Finds first Collectie in this BIOME
        // 10002 - Random number given to cloned Collectie
        // 51 - our Rextore misses
        // 1 - other Rextore hits
        // 1 - Exploring goes to encounter logic
        // 0 - Finds first Collectie in this BIOME
        // 10003 - Random number given to cloned Collectie
        hookIntoRandom(11, 10001, 1, 0, 10002, 51, 1, 1, 0, 10003);
        disableGameSleep();
        String output = runGameWithInput("n", "2", "1","2","1","5");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("Your protector is unconscious so you GTFO!!", output.split("\\r?\\n")[95]);
    }
    @Test
    public void usingRedDodudRevivesCollectie(){
        // 11 - VOLCANIC is picked as BIOME
        // 10001 - Random number given to first Collectie
        // 1 - Exploring goes to encounter logic
        // 0 - Finds first Collectie in this BIOME
        // 10002 - Random number given to cloned Collectie
        // 51 - our Rextore misses
        // 1 - other Rextore hits
        // 51 - Exploring finds item
        // 0 - Finds RedDodud
        hookIntoRandom(11, 10001, 1, 0, 10002, 51, 1, 51, 0);
        disableGameSleep();
        String output = runGameWithInput("n", "2", "1","2","3","3","1","1","6","5");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("You gave Rextore 10001 the RedDodud Sugar Free.", output.split("\\r?\\n")[81]);
        Assertions.assertEquals("Rextore 10001 has been revived!", output.split("\\r?\\n")[82]);
    }
    @Test
    public void usingRedDodudOnConsciousCollectieGivesMessage(){
        // 11 - VOLCANIC is picked as BIOME
        // 10001 - Random number given to first Collectie
        // 1 - Exploring goes to encounter logic
        // 0 - Finds first Collectie in this BIOME
        // 10002 - Random number given to cloned Collectie
        // 51 - our Rextore misses
        // 51 - other Rextore misses
        // 51 - Exploring finds item
        // 0 - Finds RedDodud   - only 2 items in VOLCANIC
        hookIntoRandom(11, 10001, 1, 0, 10002, 51, 51, 51, 0);
        disableGameSleep();
        String output = runGameWithInput("n", "2", "1","2","3","3","1","1","6","5");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("You gave Rextore 10001 the RedDodud Sugar Free.", output.split("\\r?\\n")[81]);
        Assertions.assertEquals("However, Rextore 10001 was already conscious, so nothing happened!", output.split("\\r?\\n")[82]);
    }
}
