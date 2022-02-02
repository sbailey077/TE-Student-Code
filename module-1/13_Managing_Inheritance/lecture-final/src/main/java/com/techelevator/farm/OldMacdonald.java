package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Pig()};


		Cow cow = new Cow();
		cow.wake();

		Chicken chicken = new Chicken();
		chicken.sleep();

		Cat cat = new Cat();
		cat.wake();

		/*
			FarmAnimal cannot be instantiated because it is an abstract class
		 */
		//FarmAnimal farmAnimal = new FarmAnimal("Sheep", "Baa");

		Singable[] aBunchOfSingables = new Singable[]{cow, chicken, new Pig(), new Tractor(), cat};

		for (Singable currentSingableObj : aBunchOfSingables) {
			String name = currentSingableObj.getName();
			String sound = currentSingableObj.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] aBunchOfStuffForSale = new Sellable[]{new Cow(), new Pig(), new Egg() };

		System.out.println("Welcome to our market!");
		System.out.println("Check out our items for sale! Note, no chickens :(");
		for(Sellable item : aBunchOfStuffForSale){
			System.out.println(item.getName());
			System.out.println("$" + item.getPrice());
		}




		System.out.println( Egg.calculateTotalCost(12, 1) );


	}
}