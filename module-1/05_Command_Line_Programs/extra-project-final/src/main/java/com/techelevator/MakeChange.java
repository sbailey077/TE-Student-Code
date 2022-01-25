package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.


 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the amount >>>");
		String userEnteredAmount = input.nextLine();

		double amount = Double.parseDouble(userEnteredAmount);
		double change  = 100 - amount;

		/*
			1. Create a Scanner with System.in
			2. Ask the user the amount of the bill
			3. Get the users response and store it as a double
			4. Ask the user the amount tendered
			5. Get the users response and store it as a double
			6. calculate change = tenderedAmount - amountOfBill
			7. print the change to the user
		 */
	}

}
