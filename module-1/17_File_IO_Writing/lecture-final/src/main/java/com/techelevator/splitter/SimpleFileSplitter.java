package com.techelevator.splitter;

import java.util.Scanner;

public class SimpleFileSplitter {

    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Path to file to split: ");
        String path = userInput.nextLine();
        System.out.println("Number of lines per section: ");
        int lineCount = userInput.nextInt();
        userInput.nextLine();


    }
}
