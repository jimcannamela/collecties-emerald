package com.galvanize.collecties.consumable;

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
}
