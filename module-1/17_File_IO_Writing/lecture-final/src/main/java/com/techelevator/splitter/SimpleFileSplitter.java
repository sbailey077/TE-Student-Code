package com.techelevator.splitter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleFileSplitter {

    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Path to file to split: ");
        String path = userInput.nextLine();
        System.out.println("Number of lines per section: ");
        int lineCount = userInput.nextInt();
        userInput.nextLine();

        File file = new File(path);
        try (Scanner fileScanner = new Scanner(file)) {
            int segment = 1;
            while(fileScanner.hasNextLine()) {
                int count = 0;
                List<String> linesForSegment = new ArrayList<String>();
                while (count < lineCount && fileScanner.hasNextLine()) {
                    linesForSegment.add(fileScanner.nextLine());
                    count++;
                }

                String outputPath = path + "-" + segment + ".txt";
                segment++;
                try (PrintWriter printWriter = new PrintWriter(outputPath);
                     BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {
                        for (String line: linesForSegment) {
                            bufferedWriter.write(line);
                            bufferedWriter.newLine();
                        }
                } catch(IOException e) {
                    System.out.println("Unexpected error while accessing file");
                    throw e;
                }

            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }


    }
}
