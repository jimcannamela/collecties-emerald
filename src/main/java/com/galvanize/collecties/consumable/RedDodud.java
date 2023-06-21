package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class RedDodud implements Consumable {
    @Override
    public String getName() {
        return "RedDodud Sugar Free";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new RedDodud();}

    @Override
    public Biome getContainingBiome() {
        return Biome.VOLCANIC;
    }

    @Override
    public boolean isRevivalItem(){
        return true;
    }
}
