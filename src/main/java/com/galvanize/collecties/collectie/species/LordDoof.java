package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class LordDoof extends Collectie {

    String name;

    public LordDoof() {super(CollectieType.STEEL, "soooooieeeeeeee");}

    public void setNewName(String name) {
        this.name = name;
    }
    public String getNewName() {
        return name;
    }


    @Override
    public String getGraphic() {
        return "      /\\_/\\ \n" +
                "     ( o.o )\n" +
                "      > ^ < ";
    }

    @Override
    public Biome getPreferredBiome() {
        return null;
    }

    @Override
    public int performAttack() {
        return 0;
    }

    @Override
    public boolean defend(int attackStrength) {
        return false;
    }

    @Override
    public Collectie clone() {
        return null;
    }
}
