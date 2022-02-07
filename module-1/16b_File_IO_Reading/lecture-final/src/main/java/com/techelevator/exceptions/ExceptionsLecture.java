package com.techelevator.exceptions;

import java.util.Scanner;

public class ExceptionsLecture {

    private final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean hasNumber = false;
        int number = 0;

        while(!hasNumber) {

            System.out.print("Input a whole number >>> ");
            String userSelection = input.nextLine();

            try {
                number = Integer.parseInt(userSelection);
                System.out.println("This line will not print if a NumberFormatException is thrown");
                hasNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }


        System.out.println("Your number was " + number);
    }

}
