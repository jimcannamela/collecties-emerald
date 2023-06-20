package com.galvanize.collecties.consumable;

public class Guppies implements Consumable {

	private int fish = 3;

	@Override
	public String getName() {
		return String.format(
				"Fresh Guppies from the Ocean (%d)",
				fish);
	}

	@Override
	public boolean consume() {
		if(fish == 0) return true;

		fish--;
		return fish == 0;
	}

	@Override
	public Consumable clone() {
		return new Guppies();
	}
}