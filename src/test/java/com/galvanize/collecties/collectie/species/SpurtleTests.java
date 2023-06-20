package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Spurtle")
public class SpurtleTests {

	Spurtle spurtle;

	@BeforeEach
	public void testSetup() {
		spurtle = new Spurtle();
	}

	@Test
	public void shouldBeAbleToRename() {
		String newName = "Mortimertle";
		spurtle.setName(newName);
		assertEquals(newName, spurtle.getName());
	}

	@Test
	public void shouldBeSpurtleSpecies() {
		assertEquals("Spurtle", spurtle.getSpecies());
	}

	@Test
	public void shouldBeTypeSpecial() {
		Assertions.assertEquals(CollectieType.MARINE, spurtle.getType());
	}

	@Test
	public void shouldProvideAGraphic() {
		String graphic = spurtle.getGraphic();
		System.out.println(graphic);
		assertNotEquals(0, graphic.length());
	}

	@Test
	public void shouldHaveTheCorrectSound() {
		assertEquals("SPURTLE-SPURTLE", spurtle.speak());
	}

	@Test
	public void shouldPreferOceanicBiomes() {
		assertEquals(Biome.OCEANIC, spurtle.getPreferredBiome());
	}

	@Test
	public void shouldHaveThreeAttackPower() {
		assertEquals(3, spurtle.performAttack());
	}

	@Test
	public void shouldSuccessfullyDefend25pOfTheTime() {
		int wins =  0;
		for(int i = 0; i < 1000; i++) {
			if(spurtle.defend(0)) wins++;
		}

		System.out.println("Wins: " + wins);
		assertTrue(wins > 200 && wins < 300);
	}

	@Test
	public void shouldGetNewSpurtleOnClone() {
		Spurtle clone = spurtle.clone();
		assertNotEquals(clone, spurtle);
	}
}
