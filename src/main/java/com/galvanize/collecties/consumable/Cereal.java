package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class Cereal implements Consumable {

    @Override
    public String getName() {
        return "Chocolate Blasted Sugar Bombs";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new Cereal();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.SAVANNA;
    }

    @Override
    public int hpRecovered() {
        return -5;
    }
}
