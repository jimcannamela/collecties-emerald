package com.galvanize.collecties.collectie.species;
import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Dodud extends Collectie {

  public Dodud() {
    super(CollectieType.SPECIAL, "doooooo-up", 10);
  }

  @Override
  public String getGraphic() {
    return "\\|/          (__)    \n" +
      "     `\\------(oo)\n" +
      "       ||    (__)\n" +
      "       ||w--||     \\|/\n" +
      "   \\|/";
  }

  @Override
  public Biome getPreferredBiome() {
    return Biome.PLAINS;
  }

  @Override
  public int performAttack() {
    return 0;
  }

  @Override
  public boolean defend(int attackStrength) {
    return false;
  }

  @Override
  public String getInfo() {
    return "Dodud: A quirky and delicious creature with an tasty disposition, skilled at releasing methane gas into the upper stratosphere.";
  }

  @Override
  public Dodud clone() {
    return new Dodud();
  }

  @Override
  public String special() {
    return null;
  }
}
