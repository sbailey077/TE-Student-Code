package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		System.out.println("What is the name of the file that should be searched?");

		Scanner fileInput = new Scanner(System.in);

		String path = fileInput.nextLine();

		System.out.println("What is the search word that you are looking for?");

		String searchWord = fileInput.nextLine();

		String caseSensitive = "";
		while(!caseSensitive.equalsIgnoreCase("y") && !caseSensitive.equalsIgnoreCase("n")) {
			System.out.println("Should this search be case sensitive? (Y/N)");
			caseSensitive = fileInput.nextLine();
		}

		File file = new File(path);

		int lineCount = 1;
		int searchWordCount = 0;

		try(Scanner fileToRead = new Scanner(file)) {
			if (caseSensitive.equalsIgnoreCase("y")){
				while(fileToRead.hasNextLine()) {
					String line = fileToRead.nextLine();
					if (line.contains(searchWord)) {
						System.out.println(lineCount + ": " + line);
						searchWordCount++;
					} lineCount++;
				}
			} else if (caseSensitive.equalsIgnoreCase("n")) {
				while(fileToRead.hasNextLine()) {
					String line = fileToRead.nextLine();
					if (line.toLowerCase(Locale.ROOT).contains(searchWord.toLowerCase(Locale.ROOT))) {
						System.out.println(lineCount + ": " + line);
						searchWordCount++;
					} lineCount++;
				}
			}
			if (searchWordCount == 0) {
				System.out.println("The word " + searchWord + " could not be found.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File " + file.getAbsolutePath() + " does not exist.");
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}
}
