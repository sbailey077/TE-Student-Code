package com.techelevator;

import java.util.Scanner;

public class CatPackingCalculator {

    /*
        Take Input from the user
        Calculate data (do something)
        Give output (response to the user)
     */
    public static void main(String[] args) {

        /*
            1. GET THE USER INPUT
         */
        Scanner userInput = new Scanner( System.in );

        System.out.print("What is the length of the container in feet: ");
        String userEnteredLength = userInput.nextLine();
        /*
            Scanner nextLine() will always the user input as a String
            Double.parseDouble() will parse (convert) the string value into a double
         */
        double containerLength = Double.parseDouble(userEnteredLength);

        System.out.print("What is the width of the container in feet: ");
        /*
            Scanner nextDouble() will return the user input as a double, but
            will leave a trailing newline on the input stream, which MUST be cleaned up
            by calling nextLine() after it.
         */
        double containerWidth = userInput.nextDouble();
        userInput.nextLine();

        System.out.print("What is the height of the container in feet: ");
        String userEnteredHeight = userInput.nextLine();
        double containerHeight = Double.parseDouble(userEnteredHeight);

        /*
            2. CALCULATE THE RESULT
         */
        double containerVolume = containerHeight * containerLength * containerWidth;
        double averageVolumeOfHouseCat = 0.083;

        double catsByVolume = containerVolume / averageVolumeOfHouseCat;
        double estimatedPackingDensityOfHouseCat = 0.5;

        double numberOfCats = catsByVolume * estimatedPackingDensityOfHouseCat;

        /*
            3. GIVE OUTPUT TO THE USER

            height    width     length          cats
            ------------------------------------------
            10        15         2              1807
         */
        System.out.println();

        System.out.printf("%-15s %-15s %-15s %-25s %n", "Height", "Width", "Length", "Cats In Box");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-6.0f %n", containerHeight, containerWidth, containerLength, numberOfCats);


    }
}
