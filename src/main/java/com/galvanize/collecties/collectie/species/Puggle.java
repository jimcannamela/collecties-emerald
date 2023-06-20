package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;
public class Puggle extends Collectie{
    public Puggle() {
        super(CollectieType.ELEMENTAL, "Bark");
    }

    public String getGraphic() {
        return "   /\\\n" +
                "  (  )\n" +
                " ( '_')";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.BEACH;
    }

    @Override
    public int performAttack() {
        return 7;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        if(attackStrength == 10){
            return true;
        }
        return Game.randogen.nextInt(100) > 33;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Puggle clone() {
        return new Puggle();
    }
}
