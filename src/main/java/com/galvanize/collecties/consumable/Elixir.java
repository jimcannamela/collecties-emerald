package com.galvanize.collecties.consumable;

public class Elixir implements Consumable{

    private int dosages = 3;
    @Override
    public String getName() {
        return String.format(
                "Recovers 100%% health from Shark Attacks. Remaining usage (%d)",
                dosages);
    }

    @Override
    public boolean consume() {
        if(dosages == 0) return true;
        dosages--;
        return dosages == 0;
    }

    @Override
    public Consumable clone() {
        return new Elixir();
    }
}
