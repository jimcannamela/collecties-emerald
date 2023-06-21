package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Hobbes extends Collectie {

    public Hobbes() {
        super(CollectieType.HOMICIDAL_JUNGLE_CAT, "Yukon-Ho", 100);
}

    @Override
    public String getGraphic() {
        return
                "                                                         11        1100001                                                                            \n" +
                "                                                        0000010001000000001                                                                           \n" +
                "                                                      11000011110111111001                                                                            \n" +
                "                                                     101   10011111111001                                                                             \n" +
                "                                                    11       111111110001                                                                             \n" +
                "                                                    1          1111111110                                                                             \n" +
                "                                                    1          111111111111101                                                                        \n" +
                "                                                   11          1111111101 1011                                                                        \n" +
                "                                                   1111  1      1011       11111                                                                      \n" +
                "                                                    111  11                111                                                                        \n" +
                "                                                   11 1                     111                                                                       \n" +
                "                                                  1110001                1111                                                                         \n" +
                "                                                  10111001               1111                                                                         \n" +
                "                                                  100000001             11 111                                                                        \n" +
                "                                                   10011   11        1                                                                                \n" +
                "                                                   11      11 1 1   101                                                                               \n" +
                "                                                  11     100111    101011                                                                             \n" +
                "                                                  10      101     101100111                                                                           \n" +
                "                                                  10     110     1011001111011                                                                        \n" +
                "                                                  101     11     110011110000011                                                                      \n" +
                "                                                  101 11111       1111110001111001                                                                    \n" +
                "                                                 00101001        1111110001111001101                                                                  \n" +
                "                                                10011101        1010000011110001111101                                                                \n" +
                "                                              1110001101        11111101    10000001111                                                               \n" +
                "                                              001111101         10111101     10001111101                                                              \n" +
                "                                              0011111011        1111000      10001111100                                                              \n" +
                "                                             1111100001         1111111   10011111100011                                                              \n" +
                "                                             101111011          111111111111001111111                                                                 \n" +
                "                                             101111111          100000110011110011                                                                    \n" +
                "                                               1111111          11111    10011                                                                        \n" +
                "                                                    11          11        101                                                                         \n" +
                "                                                    11          111111    10                                                                          \n" +
                "                                                    1           000001    10                                                                          \n" +
                "                                                    11          111111   101                                                                          \n" +
                "                                                    11          111101   001                                                                          \n" +
                "                                                    11         1011101  111                                                                           \n" +
                "                                                    1          1111111111                                                                             \n" +
                "                                                    1          101111101                                                                              \n" +
                "                                                    1          110000001                                                                              \n" +
                "                                                    1          111111111                                                                              \n" +
                "                                                    1          100000001                                                                              \n" +
                "                                                    1          111111111                                                                              \n" +
                "                                                    11         111111111                 11111001111                                                  \n" +
                "                                                    11         101111111               1101111001100111                                               \n" +
                "                                                    10         111111110             1111100111111011001                                              \n" +
                "                                                    101        1111111101           1111101        100001                                             \n" +
                "                                                    101        0111000001          100001           11111                                             \n" +
                "                                                    1011      11111111101         111101            10101                                             \n" +
                "                                                    10001    100000000001       1001111             10001                                             \n" +
                "                                                    1011111111111111111101      111101              11111                                             \n" +
                "                                                     001111000011111000001    1101111               00111                                             \n" +
                "                                                     1011111110110111100100111110011               101101                                             \n" +
                "                                                     10111111100000000011001101111                100111                                              \n" +
                "                                                 111111      10011111110001111011                100000                                               \n" +
                "                                                11        1111111111111111100111                1000001                                               \n" +
                "                                                111      11                101                 1000001                                                \n" +
                "                                             111101      1 1               10001111            10001                                                  \n" +
                "                                                  111111 1101 11         1111                                                                         \n" +
                "                                                        111111111111111111                                                                            \n" ;
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
