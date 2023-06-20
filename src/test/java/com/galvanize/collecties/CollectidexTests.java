package com.galvanize.collecties;

import com.galvanize.collecties.collectie.species.CollectieSpecies;
import com.galvanize.collecties.collectie.species.Rextore;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CollectidexTests {

    private Printer printer;
    private Prompt prompt;
    private Collectidex collectidex;

    @BeforeEach
    public void setup(){
        prompt = new Prompt(new Scanner(System.in), printer);
        printer = new Printer();
        collectidex = new Collectidex(printer, prompt);
    }

    @Test
    public void gotoCollectidexMenu_MenuOptionsAreProperlyCreated(){
        String[] actual = collectidex.getSpeciesMenuItems();

        List<String> actualList = Arrays.asList(actual);

        assertTrue(actualList.contains("REXTORE"));
        assertTrue(actualList.contains("Exit"));
    }

    @Test
    public void printCollectieInfo_relevantInfoPrinted() {
        String actual = collectidex.printCollectieInformation(new Rextore());
        String expected = "Rextore enjoys long walks on the beach after a bountiful feast of Dodud filets";
        assertEquals(expected,actual, "Should return rextore's beachy post-feast walk string");
    }

}
