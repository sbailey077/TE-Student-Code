package com.techelevator;

import java.util.Locale;

public class Lecture {


	public static void main(String[] args) {



		System.out.println("************************************");
		System.out.println("******    CREATING OBJECTS    ******");
		System.out.println("************************************");

		/*
			1. Declare a variable to hold the object
			2. Instantiate (create) a new copy of the object from the class using the new keyword
			3. Initialize the object with the starting values
		 */
		Cake chocolateCake = new Cake("Chocolate", true);
		/*  Cake strawberryCake = new Cake("Strawberry", false) */
		Cake strawberryCake = new Cake("Strawberry", false);

		/*
			Each object is distinct so changing one does not change the others
		 */
		chocolateCake.setIcingColor("Blueberry");

		/*
			All classes define a Data Type, so we can use them as variables,
			Arrays, or pass them to or from methods
		 */

		Cake[] cakes = new Cake[2];
		cakes[0] = chocolateCake;
		cakes[1]  = strawberryCake;


		/*
			primitive data types (value types)  are stored on the Stack
		 */
		int i = 10;
		boolean isRed = true;
		double pi = 3.14;

		/*
			Reference Types are stored on the heap and a reference to the location
			where they are stored on the heap is stored on the stack
		 */
		String greeting = "Hello";
		int[] scores = new int[15];

		int x = 10;
		int y = x;
		x = 20;

		int[] numbers = new int[]{ 10, 20, 30};
		int[] moreNumbers = numbers;

		moreNumbers[0] = 100;
		numbers[1] = 200;




		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String greetings = "Hello ";
		/* String greetings = new String("Hello"); */

		/*
			Strings are immutable, meaning that once created the value can never be changed
		 */
		String greetingsUpperCased = greetings.toUpperCase();

		String bootcampName = "Tech Elevator";
		// String methods don't change the original String, but create a new String with the change
		bootcampName.toUpperCase();
		// We must capture the return of the new changed String to use it
		String bootcampUserCase = bootcampName.toUpperCase();


		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}


		
		System.out.println();
		System.out.println("*******************************");
		System.out.println("**** STRING MEMBER METHODS ****");
		System.out.println("*******************************");
		System.out.println();

		String name = "Tech Elevator";

		// Get the length()
		int length = name.length();
		// Can get the character at a specific index
		System.out.println( name.charAt(3) );

		for (int n = 0; n < name.length(); n++) {
			System.out.println( name.charAt(n) );
		}

		// Substring = gets a portion of the string
		// ( startingIndex-Inclusive,  endingIndex-Exclusive)
		String subString = name.substring(5, 9);

		// If only give it a starting index, then gets from there to the rest of the string
		String subStringToEnd = name.substring(5);

		if ( name.contains("Elev")) {
			System.out.println("This string contains Elev");
		}

		System.out.println( name.startsWith("Tech") );
		System.out.println( name.endsWith("vator") );

		// Index of returns the first index of a character
		System.out.println(  name.indexOf("e") );

		String replace = name.replace("Elevator", "Escalator");

		// Split breaks a string into an array "split" on the specific character
		String[] parts = name.split("e");

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		/*
			Static methods like valueOf() and join() are available on the Data Type and not the objects
		 */
		int someNumber = 13;
		String numberAsString = String.valueOf(someNumber);

		/*
			Join - joins together multiple strings split by a delimiter
			String.join(deliminter, string1, string2, ...)
		 */

		String countDown = String.join(" --> ", "Five", "Four",
				"Three", "Two", "One");
		System.out.println(countDown);
	}
}
