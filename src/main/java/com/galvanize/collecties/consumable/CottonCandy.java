package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class CottonCandy implements Consumable{
    @Override
    public String getName() {
        return "IronFang Pink Cotton Candy";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new CottonCandy();}

    @Override
    public Biome getContainingBiome() {
        return Biome.BOG;
    }

    @Override
    public int hpRecovered() {
        return 30;
    }
}
