package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class KetchupPacket implements Consumable{
    @Override
    public String getName() {
        return "Brand-name Ketchup Packet";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new KetchupPacket();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.BEACH;
    }
}
