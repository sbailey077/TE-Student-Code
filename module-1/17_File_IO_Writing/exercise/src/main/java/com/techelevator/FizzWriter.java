package com.techelevator;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter the destination file:");
		String destinationFile = userInput.nextLine();

		List<String> intList = new ArrayList<String>();
		for (int i = 1; i <= 300; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				intList.add("FizzBuzz");
			} else if (i % 3 == 0) {
				intList.add("Fizz");
			} else if (i % 5 == 0) {
				intList.add("Buzz");
			} else {
				intList.add(String.valueOf(i));
			}
		}

		try(PrintWriter printWriter = new PrintWriter(destinationFile);
			BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {
			for (String s : intList ) {
				bufferedWriter.write(s);
				bufferedWriter.newLine();
			}
		} catch(IOException e) {
			System.out.println("Unexpected error occurred.");
		}
	}

}
