package com.techelevator;

import java.sql.Array;
import java.util.*;
import java.util.Map.Entry;

public class Lecture_Map {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		/*
			Declared with Map interface and instantiated with HashMap implementation class

			Map<key_dataType, value_dataType>
		 */
		Map<String, String> animalNoises = new HashMap<String, String>();

		/*
			Add items to the Map with put(key_datatype, value_datatype)
		 */
		animalNoises.put("Cow", "Moo");
		animalNoises.put("Chicken", "Cluck");
		animalNoises.put("Dog", "Bark");
		animalNoises.put("Cat", "Meow");
		/*
			The keys must be unique
			The values can be duplicates
		 */
		animalNoises.put("Lion", "Roar");
		animalNoises.put("Duck", "Roar");

		/*
			If use put with an existing key, then the value is updated
		 */
		animalNoises.put("Duck", "quack");

		/*
			Retrieve a value from the Map using get(key)
		 */
		String catNoise = animalNoises.get("Cat");
		System.out.println("The Cat says " + catNoise);

		/*
			If try to get a value for a key that does not exist in the map
			null is returned
		 */
		String thereIsNoWolf = animalNoises.get("Wolf");

		/*
			"cat" is not found and returns null because the key in the map is "Cat"
			and the key is case-sensitive
		 */
		String keysAreCaseSensitive = animalNoises.get("cat");


		/*
			remove(key) - removes the key/value pair from the Map and returns the value
		 */
		String lionNoise = animalNoises.remove("Lion");

		/*
			If try to remove a key that does not exist, then null is returned.
		 */
		String lionIsNoLongerInTheMap = animalNoises.remove("Lion");


		/*
			containsKey(key) - returns true/false if a key exists in the map or not
		 */
		boolean doesCatExistInMap = animalNoises.containsKey("Cat");
		boolean doesLionExistInMap = animalNoises.containsKey("Lion");

		/*
			containsValue(value) - returns true/false if a value exists in the map or not
		 */
		boolean doesMeowExistInMap = animalNoises.containsValue("Meow");
		boolean doesRoarExistInMap = animalNoises.containsValue("Roar");

		/*
			keySet() returns a Set of the keys in the map
		 */
		Set<String> animalNoiseKeys = animalNoises.keySet();
		/*
			entrySet() returns a Set of Entry<T, T> objects where each entry has 1 key and value pair from the Map
		 */
		Set<Entry<String, String>> animalNoiseEntrySet = animalNoises.entrySet();

		/*
			Can loop through the Entry Set and access the key and value for each one using
				getKey() and getValue()
		 */
		for (Entry<String, String> entry : animalNoises.entrySet()) {
			System.out.println("The " + entry.getKey() + " says " + entry.getValue());
		}


		System.out.println();
		System.out.println("####################");
		System.out.println("      MAP ORDER     ");
		System.out.println("####################");
		System.out.println();

		System.out.println("The values where inserted in the following order: 2, 10, 25, 1");


		// HashMap does not retain order
		System.out.println();
		System.out.println("  HASHMAP");
		System.out.println("Does not retain any order.  Instead it uses it's own internal ordering");

		Map<Integer, String> hashMapNumbersToWords = new HashMap<Integer, String>();

		hashMapNumbersToWords.put(2, "Two");
		hashMapNumbersToWords.put(10, "Ten");
		hashMapNumbersToWords.put(25, "Twenty-Five");
		hashMapNumbersToWords.put(1, "One");

		for (Integer number : hashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + hashMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("  LINKED HASHMAP");
		System.out.println("Retains the Order of Insertion");

		Map<Integer, String> linkedHashMapNumbersToWords = new LinkedHashMap<Integer, String>();

		linkedHashMapNumbersToWords.put(2, "Two");
		linkedHashMapNumbersToWords.put(10, "Ten");
		linkedHashMapNumbersToWords.put(25, "Twenty-Five");
		linkedHashMapNumbersToWords.put(1, "One");

		for (Integer number : linkedHashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + linkedHashMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("  TREEMAP");
		System.out.println("Retains the Natural Order of the Data Type");
		System.out.println();
		System.out.println("Natural Order when numbers are Integer");

		Map<Integer, String> treeMapNumbersToWords = new TreeMap<Integer, String>();

		treeMapNumbersToWords.put(2, "Two");
		treeMapNumbersToWords.put(10, "Ten");
		treeMapNumbersToWords.put(25, "Twenty-Five");
		treeMapNumbersToWords.put(1, "One");

		for (Integer number : treeMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + treeMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("TreeMap Natural Order when numbers are String");

		Map<String, String> treeMapNumbersAsStrings = new TreeMap<String, String>();

		treeMapNumbersAsStrings.put("2", "Two");
		treeMapNumbersAsStrings.put("10", "Ten");
		treeMapNumbersAsStrings.put("25", "Twenty-Five");
		treeMapNumbersAsStrings.put("1", "One");

		for (String number : treeMapNumbersAsStrings.keySet()) {
			System.out.println(number + " is " + treeMapNumbersAsStrings.get(number));

		}

		System.out.println();
		System.out.println("####################");
		System.out.println("     Problems     ");
		System.out.println("####################");
		System.out.println();

		/*
			Given the following Map, transfer half the funds from account 12345 to account 56789
		 */
		Map<Integer, Double> accounts = new HashMap<Integer, Double>();
		accounts.put(12345, 100d);
		accounts.put(56789, 200d);

		double halfOfAccount12345 = accounts.get(12345) / 2.0;
		accounts.put(12345, halfOfAccount12345);
		accounts.put(56789, accounts.get(56789) + halfOfAccount12345);


		/*
			Given the following Array count how many times each name exists
		 */
		String[] names = {"Rachelle", "John", "Rachelle", "Steve", "Dan", "Matt", "John", "Matt", "Rachelle", "Steve", "John", "Rachelle", "Rachelle" };

		// Map of Name, Count
		Map<String, Integer> nameCounts = new HashMap<String, Integer>();

		for (String name: names) {
			// if the name exists in the Map
			if (nameCounts.containsKey(name)) {
				// Update the count for that name +1
				nameCounts.put(name, nameCounts.get(name) + 1);
			} else {
				// Add it to the map with a count of 1
				nameCounts.put(name, 1);
			}
		}


		/*
			Keep track of items you want to purchase at the store
			What collection would be best?

			Items: Apples, Oranges, Bread, Milk, Soup, Ceiling Cleaner, Duct Tape, Hot Glue Gun, Googly Eyes, Pink Glitter Glue

		 */
		List<String> shoppingList = new ArrayList<String>();
		shoppingList.add("Apples");
		shoppingList.add("Pink Glitter Glue");
		shoppingList.add("Googly Eyes");



		/*
			Shuffle the given array of numbers
		 */
		Integer[] numbers = new Integer[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		List<Integer> numbersList = Arrays.asList(numbers);
		Collections.shuffle(numbersList);

		System.out.println( numbersList );

		/*
			Create an Inventory for the following items
			What collection would work best?

			Example:
			A1: Candy Bar
			A2: Nut Bar
			A3: Bag of Chocolates
			B1: Potato Chips
			B2: Pretzels
			B3: Nutter Butters
			C1: Cat Treats
			C2: Dog Treats
			C3: Squirrel Treats
		 */
		Map<String, String> vendingItems = new HashMap<String, String>();
		vendingItems.put("A1", "Candy Bar");
		vendingItems.put("A2", "Nut Bar");
		vendingItems.put("B1", "Potato Chips");
		vendingItems.put("C3", "Squirrel Treats");

		String itemFromMachine = vendingItems.get("C3");


		/*
			Keep of students in multiple classes
		 */
		// Keep track of Java Blue Students
		List<String> javaBlueStudents = new ArrayList<String>();
		javaBlueStudents.add("Will");
		javaBlueStudents.add("Ben");
		javaBlueStudents.add("Sam");
		javaBlueStudents.add("Amanda");

		List<String> javaGreenStudents = new ArrayList<String>();
		javaGreenStudents.add("Luke");
		javaGreenStudents.add("Lucas");
		javaGreenStudents.add("Sam");

		List<String> netStudents = new ArrayList<String>();
		netStudents.add("Chris");
		netStudents.add("Jason");
		netStudents.add("Patrick");

		Map<String, List<String>> classes = new HashMap<String, List<String>>();
		classes.put("javaBlue", javaBlueStudents);
		classes.put("javaGreen", javaGreenStudents);
		classes.put("dotnet", netStudents);

		for (String student : classes.get("javaBlue")) {
			System.out.println(student);
		}
	}

}
