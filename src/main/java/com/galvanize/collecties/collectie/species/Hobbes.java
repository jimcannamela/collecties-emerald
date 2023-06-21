package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Hobbes extends Collectie {

    public Hobbes() {
        super(CollectieType.HOMICIDAL_JUNGLE_CAT, "Yukon-Ho");
}

    @Override
    public String getGraphic() {
        return  "   /\\_/\\\n" +
                "  / . . \\\n" +
                " (  >w<  )\n" +
                "  )     (       _\n" +
                " (  \\_/  )    (  )\n" +
                " /       \\  /  /-\\ \\\n" +
                "/|       |\\/  /   ( ) \n" +
                "\\ \\_   _/ / /\n" +
                " \\_)))_((_/ \n";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.JUNGLE;
    }

    @Override
    public int performAttack() {
        return 21;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 50;
    }

    @Override
    public String getInfo() {
        return "Hobbes: A charismatic and agile combatant, bringing the mischievous yet loyal nature of a true friend into battle.";
    }

    @Override
    public Hobbes clone() {
        return new Hobbes();
    }
}
