package com.galvanize.collecties.consumable;

public class SubSandwich implements Consumable {

    @Override
    public String getName() {
        return "This is a Roast Rextore sub, made from the finest Rextore.";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new SubSandwich();
    }
}
