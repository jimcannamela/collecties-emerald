package com.galvanize.collecties;

import com.galvanize.collecties.collectie.Collectie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.galvanize.collecties.GameHelper.*;

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
        String input = "n\n4\n";
        disableGameSleep();
        String output = runGameWithInput(input);
        enableGameSleep();
        System.out.println(output);
        displayOutputLines(output);
        Assertions.assertEquals("?: Thank you for playing!", output.split("\\r?\\n")[13]);
    }

    @Test
    public void showCollectionThenExit() {
        List<String> gameInput = new ArrayList<>(Arrays.asList("n", "3", "1", "6", "4"));
        String output = runGameWithInput(gameInput);
        System.out.println(output);
        Assertions.assertTrue(output.contains("Collectie Collection"));
    }

    @Test
    public void showNoConsumablesOnGameStartThenExit() {
        String output = runGameWithInput("n", "3", "2", "6", "4");
        System.out.println(output);
        Assertions.assertTrue(output.contains("No consumables available"));
    }

    @Test
    public void canRenameCollectie() {
        String output = runGameWithInput("n", "3", "4", "1", "Rexter", "y", "1", "6", "4");
        displayOutputLines(output);
        Assertions.assertEquals("[1] Rexter (Rextore) ", output.split("\\r?\\n")[34]);
    }

    @Test
    public void canRenameCollectieNotHappyWithName() {
        String output = runGameWithInput("n", "3", "4", "1", "Rexter", "n", "Rexy", "y", "1", "6", "4");
        displayOutputLines(output);
        Assertions.assertEquals("[1] Rexy (Rextore) ", output.split("\\r?\\n")[37]);
    }

    @Test
    public void attemptToFeedCollectieWithNoConsumables() {
        String output = runGameWithInput("y", "Rextor", "y", "3", "3", "1", "6", "4");
        displayOutputLines(output);
        Assertions.assertEquals("?: You have no consumables to feed Rextor!", output.split("\\r?\\n")[26]);
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
        String output = runGameWithInput("n", "2", "4");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("You found a Rextore Claws Energy Drink while exploring.", output.split("\\r?\\n")[14]);
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
        String output = runGameWithInput("n", "2", "1", "n", "4");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("Would you like to capture the wild Rextore?", output.split("\\r?\\n")[50]);
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
        String output = runGameWithInput("n", "2", "1", "4");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("The wild Rextore manages to survive the blow!", output.split("\\r?\\n")[49]);
        Assertions.assertEquals("Rextore 10001 survives the blow!", output.split("\\r?\\n")[52]);
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
        String output = runGameWithInput("n", "2", "1","3","1","6","4");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("The wild Rextore manages to survive the blow!", output.split("\\r?\\n")[49]);
        Assertions.assertEquals("Rextore 10001 has fallen and is unconscious!", output.split("\\r?\\n")[52]);
        Assertions.assertEquals("[1] Rextore 10001 (Rextore) [UNCONSCIOUS]", output.split("\\r?\\n")[67]);
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
        String output = runGameWithInput("n", "2", "1","2","1","4");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("Your protector is unconscious so you GTFO!!", output.split("\\r?\\n")[93]);
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
        String output = runGameWithInput("n", "2", "1","2","3","3","1","1","6","4");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("You used the RedDodud and revived the Collectie", output.split("\\r?\\n")[81]);
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
        String output = runGameWithInput("n", "2", "1","2","3","3","1","1","6","4");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("You used the RedDodud, but your Collectie was already conscious", output.split("\\r?\\n")[81]);
    }
}
