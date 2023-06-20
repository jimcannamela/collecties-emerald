package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Shark extends Collectie {
    public Shark() {
        super(CollectieType.AQUA, "sharrrK");
    }

    @Override
    public String getGraphic() {
        return "Image had problems";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.OCEANIC;
    }

    @Override
    public int performAttack() {
        return 100;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 50;
    }

    @Override
    public Shark clone() {
        return new Shark();
    }
}
