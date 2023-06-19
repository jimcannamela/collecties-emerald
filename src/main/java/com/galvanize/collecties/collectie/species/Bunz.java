package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Bunz extends Collectie {

    public Bunz() {
        super(CollectieType.SNACK, "NO SAUERKRAUT");
    }

    @Override
    public String getGraphic() {

        return "               .---. __\n" +
                "    ,         /     \\   \\    ||||\n" +
                "   \\\\\\\\      |O___O |    | \\\\||||\n" +
                "   \\   //    | \\_/  |    |  \\   /\n" +
                "    '--/----/|     /     |   |-'\n" +
                "           // //  /     -----'\n" +
                "          //  \\\\ /      /\n" +
                "         //  // /      /\n" +
                "        //  \\\\ /      /\n" +
                "       //  // /      /\n" +
                "      /|   ' /      /\n" +
                "      //\\___/      /\n" +
                "     //   ||\\     /\n" +
                "     \\\\_  || '---'\n" +
                "     /' /  \\\\_.-\n" +
                "    /  /    --| |\n" +
                "    '-'      |  |\n" +
                "              '-'";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.BEACH;
    }

    @Override
    public int performAttack() {
        return 10;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 50;
    }

    @Override
    public Bunz clone() {
        return new Bunz();
    }
}
