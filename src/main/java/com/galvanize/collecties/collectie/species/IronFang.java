package com.galvanize.collecties.collectie.species;
import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class IronFang extends Collectie {

    String name;

    public IronFang() {super(CollectieType.FAIRY, "BIDOOOOOOOF");}

    public void setNewName(String name) {
        this.name = name;
    }
    public String getNewName() {
        return name;
    }


    @Override
    public String getGraphic() {
        return "      /\\_/\\ \n" +
                "     ( o.o )\n" +
                "      > ^ < ";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.BOG;
    }

    @Override
    public int performAttack() {
        return 100;
    }

    @Override
    public boolean defend(int attackStrength) {
        return true;
    }

    @Override
    public String getInfo() {
        return "IronFang: A formidable and imposing fairy, adorned with metallic armor and possessing razor-sharp fangs, striking fear into the hearts of its foes.";
    }

    @Override
    public IronFang clone() {
        return new IronFang();
    }
}
