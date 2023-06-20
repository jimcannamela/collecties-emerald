package com.galvanize.collecties.consumable;

public class Ribs implements Consumable{
    private int ribs = 7;

    @Override
    public String getName() {
        return String.format(
                "Rack of Dodud ribs (%d)",
                ribs);
    }

    @Override
    public boolean consume() {
        if(ribs == 0) return true;

        ribs--;
        return ribs == 0;
    }

    @Override
    public Consumable clone() {
        return new Ribs();
    }
}