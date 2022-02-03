package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean isSleeping = false;


	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	/*
		An abstract method works like an interface and forces
		any subclass to implement it
	 */
	public abstract void eat();


	public String getName() {
		return name;
	}

	/*
	The final keyword prevents this method from being
	Overridden in a subclass
	 */
	public final String getSound() {
		if (isSleeping) {
			return "Zzzzzzzzzz...";
		}
		return sound;
	}

	public boolean isSleeping() {
		return isSleeping;
	}

	public void sleep() {
		isSleeping = true;
	}

	public void wake() {
		isSleeping = false;
	}


}