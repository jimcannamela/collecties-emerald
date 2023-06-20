package com.galvanize.collecties.consumable;

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
}
