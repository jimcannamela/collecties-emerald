package com.galvanize.collecties;

import com.galvanize.collecties.collectie.species.CollectieSpecies;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;
public class Collectidex {

    private Printer printer;
    private Prompt prompt;

    private String[] speciesMenuItems;

    public Collectidex(Printer printer, Prompt prompt){
        this.printer = printer;
        this.prompt = prompt;

        speciesMenuItems = new String[CollectieSpecies.values().length + 1];
        int counter = 0;
        for(CollectieSpecies species : CollectieSpecies.values()){
            speciesMenuItems[counter] = species.toString();
            counter++;
        }
        speciesMenuItems[speciesMenuItems.length - 1] = "Exit";
    }

    public String[] getSpeciesMenuItems() {
        return speciesMenuItems;
    }

}
