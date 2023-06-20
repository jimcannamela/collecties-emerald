package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Spurtle extends Collectie {

	public Spurtle() {
		super(CollectieType.MARINE, "Spurtle-Spurtle");
	}

	@Override
	public String getGraphic() {
		return "               _,........__\n" +
				"            ,-'            \"`-.\n" +
				"          ,'                   `-.\n" +
				"        ,'                        \\\n" +
				"      ,'                           .\n" +
				"      .'\\               ,\"\".       `\n" +
				"     ._.'|             / |  `       \\\n" +
				"     |   |            `-.'  ||       `.\n" +
				"     |   |            '-._,'||       | \\\n" +
				"     .`.,'             `..,'.'       , |`-.\n" +
				"     l                       .'`.  _/  |   `.\n" +
				"     `-.._'-   ,          _ _'   -\" \\  .     `\n" +
				"`.\"\"\"\"\"'-.`-...,---------','         `. `....__.\n" +
				".'        `\"-..___      __,'\\          \\  \\     \\\n" +
				"\\_ .          |   `\"\"\"\"'    `.           . \\     \\\n" +
				"  `.          |              `.          |  .     L\n" +
				"    `.        |`--...________.'.        j   |     |\n" +
				"      `._    .'      |          `.     .|   ,     |\n" +
				"         `--,\\       .            `7\"\"' |  ,      |\n" +
				"            ` `      `            /     |  |      |    _,-'\"\"\"`-.\n" +
				"             \\ `.     .          /      |  '      |  ,'          `.\n" +
				"              \\  v.__  .        '       .   \\    /| /              \\\n" +
				"               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |\n" +
				"                `        .        `._ ___,j.  `/ .-       ,---.     |\n" +
				"                ,`-.      \\         .\"     `.  |/        j     `    |\n" +
				"               /    `.     \\       /         \\ /         |     /    j\n" +
				"              |       `-.   7-.._ .          |\"          '         /\n" +
				"              |          `./_    `|          |            .     _,'\n" +
				"              `.           / `----|          |-............`---'\n" +
				"                \\          \\      |          |\n" +
				"               ,'           )     `.         |\n" +
				"                7____,,..--'      /          |\n" +
				"                                  `---.__,--.'mh";
	}

	@Override
	public Biome getPreferredBiome() {
		return Biome.OCEANIC;
	}

	@Override
	public int performAttack() {
		return 3;
	}

	@Override
	public boolean defend(int attackStrength) {
		if(Game.TEST_MODE) return false;
		return Game.randogen.nextInt(100) > 75;
	}

	@Override
	public Spurtle clone() {
		return new Spurtle();
	}
}