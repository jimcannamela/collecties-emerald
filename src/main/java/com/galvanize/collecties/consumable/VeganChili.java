package com.galvanize.collecties.consumable;

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
}