package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Shark extends Collectie {
    public Shark() {
        super(CollectieType.AQUA, "sharrrK", 100);
    }

    @Override
    public String getGraphic() {
        return "                                 ,-\n" +
                "                               ,'::|\n" +
                "                              /::::|\n" +
                "                            ,'::::o\\                                      _..\n" +
                "         ____........-------,..::?88b                                  ,-' /\n" +
                " _.--\"\"\"\". . . .      .   .  .  .  \"\"`-._                           ,-' .;'\n" +
                "<. - :::::o......  ...   . . .. . .  .  .\"\"--._                  ,-'. .;'\n" +
                " `-._  ` `\":`:`:`::||||:::::::::::::::::.:. .  \"\"--._ ,'|     ,-'.  .;'\n" +
                "     \"\"\"_=--       //'doo.. ````:`:`::::::::::.:.:.:. .`-`._-'.   .;'\n" +
                "         \"\"--.__     P(       \\               ` ``:`:``:::: .   .;'\n" +
                "                \"\\\"\"--.:-.     `.                             .:/\n" +
                "                  \\. /    `-._   `.\"\"-----.,-..::(--\"\".\\\"\"`.  `:\\\n" +
                "                   `P         `-._ \\          `-:\\          `. `:\\\n" +
                "                                   \"\"            \"            `-._)";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.OCEANIC;
    }

    @Override
    public int performAttack() {
        return 100;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 50;
    }

    @Override
    public String getInfo() {
        return "Baby Shark, do do dodo do do, Baby Shark, do do dodo do do, Baby SHARK!";
    }

    @Override
    public Shark clone() {
        return new Shark();
    }

    @Override
    public String special() {
        return null;
    }
}
