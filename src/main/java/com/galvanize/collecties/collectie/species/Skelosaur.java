package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Skelosaur extends Collectie {

    public Skelosaur() {
        super(CollectieType.FIRE, "SKEL SKEL", 100);
    }

    public String getGraphic() {
        return
        "                                |\\     /|\n" +
        "                                ||\\\\ //||\n" +
        "                                /,    ,  \\\n" +
        "                               <0/  /0>  |\n" +
        "                ______         (00)_     /                ______\n" +
        "          \\\\\\\\\\\\\\\\\\\\            |WW/    |              //////////\n" +
        "        \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\____    |      |     ____//////////////////\n" +
        "     \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\  /        \\   //////////////////////////\n" +
        "   \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\/          \\//////////////////////////////\n" +
        "  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\(     |     )///////////////////////////////\n" +
        "           ~~~~~~~\\\\\\\\\\\\\\\\\\\\\\\\|    / \\    |//////////////~~~~~~~\n" +
        "                      \\\\\\\\\\\\\\ |    | |    |////////\n" +
        "                          \\\\\\/|    | |    |\\///\n" +
        "                           /  |    | |    |  \\\n" +
        "                           \\  |    | |    |  /\n" +
        "                          __/\\ \\  /   \\  / /\\__\n" +
        "                         (vvv)(vvv)---(vvv)(vvv)\n";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.VOLCANIC;
    }

    @Override
    public int performAttack() {
        return 13;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 50;
    }

    @Override
    public Skelosaur clone() {
        return new Skelosaur();
    }

}
