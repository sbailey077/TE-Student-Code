package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderExample {

    public static void main(String[] args) {
        //get path from user
        System.out.println("Please tell us the path of the file you want to read.");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();
        System.out.println("How many lines to read?");
        String numberOfLinesToRead = input.nextLine();
        int numberOfLines = Integer.parseInt(numberOfLinesToRead);
        int countOfLines = 0;
        //create a new file object
        File file = new File(path);
//        if(!file.exists()){
//            System.out.println("File doesn't exist :(");
//        }
//        if(!file.isFile()){
//            System.out.println("File is not a file. Weirdly.");
//        }
        //try-with-resource
        try(Scanner fileToRead = new Scanner(file)){
            while(fileToRead.hasNextLine() && countOfLines < numberOfLines){
                String line = fileToRead.nextLine();
                System.out.println((countOfLines +1) + ": " + line );
                countOfLines++;
            }

        } catch( FileNotFoundException e){
            System.out.println("File " + file.getAbsolutePath() + " not found");
        }
    }
}
