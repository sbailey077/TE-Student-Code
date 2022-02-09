package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MovieRental shawshank = new MovieRental("The Shawshank Redemption", "DVD", true);

		MovieRental grandBudapest = new MovieRental("The Grand Budapest Hotel", "BluRay", true);

		shawshank.determineRentalPrice("DVD", true);
		shawshank.determineLateFee(0);
		shawshank.toString();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter in the filepath");
		String filePath = scanner.nextLine();

		File file = new File(filePath);

		List<String> movieList = new ArrayList<String>();

		try(Scanner fileToRead = new Scanner(file)) {
			String line = fileToRead.nextLine();
			while(fileToRead.hasNextLine()) {
				movieList.add(line);
			}
		} catch (FileNotFoundException e) {

		}



	}

}
