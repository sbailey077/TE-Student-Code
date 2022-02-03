package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Chicken)) {
			return false;
		}
		Chicken other = (Chicken) obj;

		if (this.getName().equals(other.getName()) &&
			this.getSound().equals(other.getSound())) {
			return true;
		}
		return false;
	}

	@Override
	public void eat() {
		System.out.println("The Chicken eats");
	}

}