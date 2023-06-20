package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;
public class Spectrecle extends Collectie{
    public Spectrecle() {
        super(CollectieType.GHOST, "BOOOOOOO");
    }

    public String getGraphic() {
        return "  _____\n" +
                " /     \\\n" +
                "| -O-O- |\n" +
                "|       |\n" +
                "|       |\n" +
                " VvVvVvV\n";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.BOG;
    }

    @Override
    public int performAttack() {
        return 5;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 67;
    }

    @Override
    public String getInfo() {
        return "Spectrecle: A deceased adversary of Pac-Man and Mrs. Pac-Man, this ghastly creature resembles a delicious 'Dots' candy";
    }

    @Override
    public Spectrecle clone() {
        return new Spectrecle();
    }
}
