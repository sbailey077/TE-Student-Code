package com.techelevator.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionsExamples {

    public static void main(String[] args) {
        ExceptionsExamples app = new ExceptionsExamples();
        app.run();
    }

    private void run() {
        /*
            Runtime Exception
         */
        int[] nums = {1, 2, 3};

        try {
            int x = nums[4];
            System.out.println("This line will not run if there is an exception above it: " + x);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index was out of bounds");
        }

        System.out.println("This line will only run if the exception is handled");

        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("File Name: ");
            String filepath = userInput.nextLine();

            try {
                readFile(filepath);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("The File was not found, please try again!");
            }
        }

    }

    private void readFile(String filepath) throws FileNotFoundException {

        File fileObj = new File(filepath);

        try (Scanner fileScanner = new Scanner(fileObj)) {
            while ( fileScanner.hasNextLine() ) {
                String lineFromFile = fileScanner.nextLine();
                System.out.println(lineFromFile);
            }
        }

    }
}
