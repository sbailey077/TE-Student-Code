package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner userInput = new Scanner (System.in);

		System.out.print("Please enter the length: ");
		String userEnteredLength = userInput.nextLine();

		System.out.println();

		double initialLength = Double.parseDouble(userEnteredLength);

		System.out.print("Is the measurement in (m)eters or (f)eet: ");
		String userEnteredUnits = userInput.nextLine();

		System.out.println();

		String newUnit = "m";

		double newLength = 0;

		if (userEnteredUnits.equalsIgnoreCase("m")) {
			newLength = initialLength * 3.2808399;
			newUnit = "f";
		} else if (userEnteredUnits.equalsIgnoreCase("f")) {
			newLength = initialLength * 0.3048;
		} else {
			newLength = 0;
		}

		System.out.println(userEnteredLength + userEnteredUnits + " is " + (int)newLength + newUnit + ".");


	}

}
