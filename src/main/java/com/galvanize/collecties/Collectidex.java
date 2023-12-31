package com.galvanize.collecties;

import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.species.CollectieSpecies;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;
public class Collectidex {

    private Printer printer;
    private Prompt prompt;

    public Collectidex(Printer printer, Prompt prompt){
        this.printer = printer;
        this.prompt = prompt;
    }

    public void getSpeciesMenuItems() {
        String[] speciesMenuItems = new String[CollectieSpecies.values().length + 1];
        int counter = 0;
        for (CollectieSpecies species : CollectieSpecies.values()) {
            speciesMenuItems[counter] = species.toString();
            counter++;
        }
        speciesMenuItems[speciesMenuItems.length - 1] = "Exit";

        printer.print(
                "Select a species of Collecties");

        printer.formatAsList(speciesMenuItems).print();
        int choice = prompt.getChoice(speciesMenuItems.length);
        if(choice == speciesMenuItems.length) return;
        String choosenCollectie = speciesMenuItems[choice - 1];
        printer.print(printCollectieInformation(CollectieSpecies.valueOf(choosenCollectie).getReference()));
        printer.print(
                "Would you like to view another collectie?");
        if(prompt.getYesNo()) getSpeciesMenuItems();
    }
    public String printCollectieInformation(Collectie collectie) {
        return collectie.getInfo();
    }

}
