package com.galvanize.collecties.consumable;

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
}
