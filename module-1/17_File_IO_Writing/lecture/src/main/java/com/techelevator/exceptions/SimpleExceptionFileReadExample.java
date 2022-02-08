package com.techelevator.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimpleExceptionFileReadExample {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Path to file >>");
        String filepath = userInput.nextLine();

        File file = new File(filepath);

        try ( Scanner fileScanner = new Scanner(file) ) {
            while (fileScanner.hasNextLine()) {
                String nextLineFromFile = fileScanner.nextLine();
                System.out.println(nextLineFromFile);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + filepath + " was not found!  Please try again.");
        }

    }
}
