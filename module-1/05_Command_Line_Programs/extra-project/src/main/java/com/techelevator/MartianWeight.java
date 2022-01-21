package com.techelevator;

import java.util.Scanner;
/*
In case you've ever pondered how much you weigh on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

$ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth is 37 lbs. on Mars.
 235 lbs. on Earth is 88 lbs. on Mars.
 185 lbs. on Earth is 69 lbs. on Mars. 
 */
public class MartianWeight {

	public static void main(String[] args) {

		// Get the User Input

		Scanner userInput = new Scanner(System.in);

		System.out.print("Please enter your weight on Earth in lbs: ");
		String userEnteredWeight = userInput.nextLine();

		double earthWeight = Double.parseDouble(userEnteredWeight);

		// Calculate the Mars weight

		double marsWeight = earthWeight * 0.378;

		System.out.println();

		// Print it out to the user

		System.out.print((int)earthWeight +" lbs. on Earth is " + (int)marsWeight + " lbs on Mars.");
	}

}
