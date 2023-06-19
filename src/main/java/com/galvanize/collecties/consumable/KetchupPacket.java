package com.galvanize.collecties.consumable;

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
}
