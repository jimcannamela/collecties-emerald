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
        return  "                           ..                                              \n" +
                "                     .~!~^^^^:~75PP5Y.                                     \n" +
                "                   .:7BPY7~7PJ~??!YB5.                                     \n" +
                "                  :?J~::~?! .~  .?B5.                                      \n" +
                "                  ^^      .  :!777?Y.  .                                   \n" +
                "                  7.        ..:.. ^?77Y!                                   \n" +
                "                  J:. ::   .777J~^7~.???7.                                 \n" +
                "                  ?~J ^5.   .~..     .?7^                                  \n" +
                "                .!?~7~:.            :^~!^                                  \n" +
                "                .P5YYPG^           :!J!:.                                  \n" +
                "                 !GGPYJ~~~      ...!^.::                                   \n" +
                "                 ^J^.  .?J:~::.:YJ^                                        \n" +
                "                 J~   :7G?^:  ~5^7G?^.                                     \n" +
                "                 J!   .!P:   ^J!7Y!.:7J!.                                  \n" +
                "                 5J :^.!?    ~JJJ  !5PJ~!J~.                               \n" +
                "               :YJ?755~^     ^^.:^5BY: ^YY7!!:                             \n" +
                "              .JB7 ~5?       ?!!!7G!^~JG!:~!J57.                           \n" +
                "             ?P::!!JY:      ^J~^^7J   .?GG7^^^~J.                          \n" +
                "            .?Y7^^!PJ.      !!^~!P!  :^7??7!!!7P~                          \n" +
                "            ~J.:~7?7.       ~^...Y!~!!YY^.:~??~:                           \n" +
                "            .?7???7?.       !J?J5?75P^.?Y7^.                               \n" +
                "              .:^.^Y        !Y^     ^5J.                                   \n" +
                "                  ^?        ??JJJ^   ?~                                    \n" +
                "                  ^!        ^^~!Y:  ~5^                                    \n" +
                "                  ~J        ~!!75. .GJ                                     \n" +
                "                  !7        ^...~!77~                                      \n" +
                "                  !~       .7!~~~?5.                                       \n" +
                "                  !~       .?:~~!75                                        \n" +
                "                  7~        ?777!?5.                                       \n" +
                "                  77        ^:::..J.             ::^^7!^::.                \n" +
                "                  75       .7~^^^~Y:          .!7J7^^Y5^?P^~!.             \n" +
                "                  !G:      ^~...:^Y!         !7: ?57^::^7?7YGY             \n" +
                "                  !G7      !7~!!!!5?        7JJ7?~        JY.J:            \n" +
                "                  ^5Y?.   ^5!~~~~~Y?      ~Y~ JJ.         ^5?5!            \n" +
                "                  .P~~!~~!!^~^~~~!7P^    ~7~?Y~           ~Y.!7            \n" +
                "                   YJ!7?J?JJ?77??YG55~.:7Y?^~:            Y?!J^            \n" +
                "                 .:!P77!~~?P?7??7?Y.5Y~Y:.J7             ?G~:!             \n" +
                "               :?7!^~. .^~7PY???7!JJ5^.7Y7:            .?GGBJ.             \n" +
                "             .:Y!~    .7~:. .....  ..7P7^...          ~GBBGJ.              \n" +
                "            .~!?Y?~:. ^?!^ ^         :5J?7!~:         :JYJ^                \n" +
                "                 :^^^^~7J!^J^^^^^^~~^^.                                    \n" +
                "                          ........                                          \n" ;
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
    public Hobbes clone() {
        return new Hobbes();
    }
}
