package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Rextore extends Collectie {

  public Rextore() {
    super(CollectieType.DINOSAUR, "rarwar", 100);
  }

  public String getGraphic() {
    return "        ,\n" +
      "       /|\n" +
      "      / |\n" +
      "     /  /\n" +
      "    |   |\n" +
      "   /    |\n" +
      "   |    \\_\n" +
      "   |      \\__\n" +
      "   \\       __\\_______\n" +
      "    \\                 \\_\n" +
      "    | /                 \\\n" +
      "    \\/                   \\\n" +
      "     |                    |\n" +
      "     \\                   \\|\n" +
      "     |                    \\\n" +
      "     \\                     |\n" +
      "     /\\    \\_               \\\n" +
      "    / |      \\__ (   )       \\\n" +
      "   /  \\      / |\\\\  /       __\\____\n" +
      "snd|  ,     |  /\\ \\ \\__    |       \\_\n" +
      "   \\_/|\\___/   \\   \\}}}\\__|  (@)     )\n" +
      "    \\)\\)\\)      \\_\\---\\   \\|       \\ \\\n" +
      "                  \\>\\>\\>   \\   /\\__o_o)\n" +
      "                            | /  VVVVV\n" +
      "                            \\ \\    \\\n" +
      "                             \\ \\MMMMM  \n" +
      "                              \\______/\n";
  }

  @Override
  public Biome getPreferredBiome() {
    return Biome.VOLCANIC;
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
  public String getInfo() {
    return "Rextore: A Jurrasic era reincarnation, he enjoys long walks on the beach with Mrs. Rextore after a bountiful feast of Dodud filets";
  }

  @Override
  public Rextore clone() {
    return new Rextore();
  }

  @Override
  public String special() {
    return null;
  }
}
