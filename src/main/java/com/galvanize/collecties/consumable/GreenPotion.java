package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class GreenPotion implements Consumable{

    private int uses = 2;

    @Override
    public String getName() {
        return String.format(
                "Green Potion (%d)",
                uses);
    }

    @Override
    public boolean consume() {
        if(uses == 0) return true;

        uses--;
        return uses == 0;
    }

    @Override
    public Consumable clone() {
        return new GreenPotion();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.VOLCANIC;
    }

    @Override
    public int hpRecovered() {
        return 75;
    }
}
