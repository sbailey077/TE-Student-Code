package com.techelevator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		//Import new scanner

		Scanner userInput = new Scanner(System.in);

		//Take user input
		System.out.print("Please enter in a series of decimal integer values (separated by spaces): ");
		String userEnteredDecimals = userInput.nextLine();

		System.out.println();

		String[] arrayOfEnteredDecimals = userEnteredDecimals.split(" ");
		int[] stringToInteger = new int[arrayOfEnteredDecimals.length];

		for (int i = 0; i < arrayOfEnteredDecimals.length; i++) {
			stringToInteger[i] = Integer.parseInt(arrayOfEnteredDecimals[i]);
		}

		for (int i = 0; i < stringToInteger.length; i++){
			System.out.println(stringToInteger[i] + " in binary is " + Integer.toBinaryString(stringToInteger[i]));
		}






	}

}
