package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		//Gather user input

		System.out.print("Please enter a number: ");
		String userEnteredString = userInput.nextLine();

		//Parse user input into an integer

		int enteredNumber = Integer.parseInt(userEnteredString);

		//Initialize the first two terms of the series

		int firstTerm = 0;
		int secondTerm = 1;

		//Create a for loop to iterate through the series

		for (int i = 0; firstTerm <= enteredNumber; i++) {

			//Print the first term and a space for the next term

			System.out.print(firstTerm + " ");

			//Create a variable for the next term

			int nextTerm = firstTerm + secondTerm;

			//Change the first term and second term once they have already printed

			firstTerm = secondTerm;
			secondTerm = nextTerm;

		}











	}

}
