package com.techelevator;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String sourceFile = userInput.nextLine();

        System.out.println("What is the destination file?");
        String destinationFile = userInput.nextLine();

        File file = new File(sourceFile);
        List<String> linesToPrint = new ArrayList<String>();
        try(Scanner fileScanner = new Scanner(file)) {
            while(fileScanner.hasNextLine()) {
                String replacementLine = "";
                String line = fileScanner.nextLine();
                if (line.contains(searchWord)) {
                    replacementLine = line.replace(searchWord, replacementWord);
                    linesToPrint.add(replacementLine);
                } else {
                    linesToPrint.add(line);
                }
            } try (PrintWriter printWriter = new PrintWriter(destinationFile);
                   BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {
                    for (String printedLine : linesToPrint) {
                        bufferedWriter.write(printedLine);
                        bufferedWriter. newLine();
                    }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + sourceFile + " not found.");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred.");
        }
    }
}
