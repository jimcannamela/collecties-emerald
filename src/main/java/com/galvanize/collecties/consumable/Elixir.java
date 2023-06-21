package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class Elixir implements Consumable{

    private int dosages = 3;
    @Override
    public String getName() {
        return String.format(
                "Shark Elixir (%d)",
                dosages);
    }

    @Override
    public boolean consume() {
        if(dosages == 0) return true;
        dosages--;
        return dosages == 0;
    }

    @Override
    public Consumable clone() {
        return new Elixir();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.OCEANIC;
    }
}
