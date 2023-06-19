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
        return "-...................-**=:...:===+*=--:................-\n" +
                ":                  -@@%#**#@#*#%#***##%#+             :\n" +
                ":                  =@@.:*%@+**-.     +#+              :\n" +
                ":                   :+%#+++=-         *+=             :\n" +
                ":                     %%#*+.          .+*             :\n" +
                ":                    .%++*=    =-  =:  +%             :\n" +
                ":                 .::-%###=    *:  #:  =%:            :\n" +
                ":               .-=+#=  .:     .---.   =%===:         :\n" +
                ":               :-=*=         ##*++=*=  .*=:          :\n" +
                ":               -+=-:.        .*@@@#*.   --..         :\n" +
                ":                   =+:       :=++=:    :--.          :\n" +
                ":                  .-.:-.    +:    .:::.:-:.          :\n" +
                ":                      .-+#%#%+--.    -=              :\n" +
                ":                   :*%##**%@%@=       *              :\n" +
                ":                 -**++**#- :==-=:     +              :\n" +
                ":               :=*%@@#++==    +       :*             :\n" +
                ":            -#@#*++#@@#+=     .=:.==+--#%.           :\n" +
                ":          -+++*#@%*+#@@+%=       :.:*%%#+=           :\n" +
                ":       =*#**++++*@@*##*+*          .++++#%*          :\n" +
                ":     +#*+++*#@%+**+%@%##*          -#%#%%##:         :\n" +
                ":    %*+**#**+*%+. .@@####           =#++++##         :\n" +
                ":   .#%@%#*+*#%+   -@@##**          -*@#*%%#**        :\n" +
                ":    :+++++%@@@##: *%@%#%#           =#**+++*@        :\n" +
                ":       :=#@#*+++##%%@+++#          .=*#####@+        :\n" +
                ":          :=+*#@%*##=-+--:::        ==-::.           :\n" +
                ":             -++*:         =:       =                :\n" +
                ":                ==     =-:-=        %#               :\n" +
                ":                *.    -*            ++               :\n" +
                ":                *::   +#.           =%               :\n" +
                ":               -%*-   ++-           =%.              :\n";
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
    public Collectie clone() {
        return new Hobbes();
    }
}
