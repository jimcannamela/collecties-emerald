package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class VeganChili implements Consumable {

    @Override
    public String getName() {
        return "A nutritious batch of chili, now featuring 0 collectie parts or byproducts!";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new VeganChili();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.SHADOW_DIMENSION;
    }
}