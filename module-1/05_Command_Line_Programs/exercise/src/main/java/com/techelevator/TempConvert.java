package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner userInput = new Scanner (System.in);

		//Ask the user to input the temperature

		System.out.print("Please enter the temperature: ");
		String userEnteredTemperature = userInput.nextLine();

		System.out.println();

		//Ask the user to input the unit

		System.out.print("Is the temperature in (C)elcius, or (F)ahrenheit? ");
		String userEnteredUnit = userInput.nextLine();

		System.out.println();

		double initialTemperature = Double.parseDouble(userEnteredTemperature);

		double newTemperature = 0;

		String newUnit = "C";

		if (userEnteredUnit.equalsIgnoreCase("C")) {
			newTemperature = initialTemperature * 1.8 + 32;
			newUnit = "F";
		} else if (userEnteredUnit.equalsIgnoreCase("F")) {
			newTemperature = (initialTemperature - 32) / 1.8;
		}

		System.out.print(userEnteredTemperature + userEnteredUnit + " is " + (int)newTemperature + newUnit);



	}

}
