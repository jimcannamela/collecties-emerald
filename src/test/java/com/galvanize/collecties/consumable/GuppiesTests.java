package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Consumable: Guppies")
public class GuppiesTests {

	Guppies guppies;

	@BeforeEach
	public void testSetup() {
		guppies = new Guppies();
	}

	@Test
	public void shouldHaveTheRightName() {
		assertEquals("Fresh Guppies from the Ocean (3)", guppies.getName());
	}

	@Test
	public void shouldHave3FishToConsume() {
		assertFalse(guppies.consume());
		assertFalse(guppies.consume());
		assertTrue(guppies.consume());
	}

	@Test
	public void shouldShowFishCountInName() {
		assertTrue(guppies.getName().contains("(3)"));
		guppies.consume();
		assertTrue(guppies.getName().contains("(2)"));
	}
}

