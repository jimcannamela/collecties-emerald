package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;
public class Pizzaiolo extends Collectie {

    public Pizzaiolo() {
        super(CollectieType.GHOST, "Ooooo0ooo0oooooo00000oooope");
    }

    public String getGraphic() {
        return "               .-. \\\\_/ .-.\\n\" +\n" +
                "                \"               \\\\.-\\\\/=\\\\/.-/\\n\" +\n" +
                "                \"            '-./___|=|___\\\\.-'\\n\" +\n" +
                "                \"           .--| \\\\|/`\\\"`\\\\|/ |--.\\n\" +\n" +
                "                \"          (((_)\\\\  .---.  /(_)))\\n\" +\n" +
                "                \"           `\\\\ \\\\_`-.   .-'_/ /`_\\n\" +\n" +
                "                \"             '.__       __.'(_))\\n\" +\n" +
                "                \"                 /     \\\\     //\\n\" +\n" +
                "                \"                |       |__.'/\\n\" +\n" +
                "                \"                \\\\       /--'`\\n\" +\n" +
                "                \"            .--,-' .--. '----.\\n\" +\n" +
                "                \"           '----`--'  '--`----'";
    }
    @Override
    public Biome getPreferredBiome() {
        return Biome.SHADOW_DIMENSION;
    }

    @Override
    public int performAttack() {
        return 999999999;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 50;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Pizzaiolo clone() {
        return new Pizzaiolo();
    }
}