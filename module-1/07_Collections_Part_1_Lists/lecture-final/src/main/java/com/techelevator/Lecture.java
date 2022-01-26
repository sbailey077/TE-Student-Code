package com.techelevator;

//can do this
//import java.util.*;
//but more specific is better to avoid class collision

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Lecture {


	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> instructors = new ArrayList<String>();

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		instructors.add("John");
		instructors.add("Brian");
		instructors.add("Steve");
		instructors.add("Matt");

		System.out.println("Let's see our instructors!!");
		for(int i = 0; i < instructors.size(); i++){

			System.out.println(instructors.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		instructors.add("John");

		for(int i = 0; i < instructors.size(); i++){

			System.out.println("Index: " + i + ": " + instructors.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		instructors.add(2, "Rachelle");

		for(int i = 0; i < instructors.size(); i++){

			System.out.println("Index: " + i + ": " + instructors.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		instructors.remove(5);

		for(int i = 0; i < instructors.size(); i++){

			System.out.println("Index: " + i + ": " + instructors.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean isRachelleEmployeed = instructors.contains("Dan");
		System.out.println(isRachelleEmployeed);

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		instructors.add("john");
		instructors.add("Dan");
		instructors.add("John");

		int findJohnInList = instructors.indexOf("john");
		System.out.println("Lowercase john is at index : " + findJohnInList);
		//instructors.lastIndexOf("John");
		System.out.println("Last index of ??? : " + instructors.lastIndexOf("John"));


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] arrayFromList = instructors.toArray(new String[instructors.size()]);

		for(int i = 0; i < arrayFromList.length; i++){

			System.out.println("Index: " + i + ": " + arrayFromList[i]);
		}

		System.out.println("########## Arrays can be turned into a List!! ###");

		List<String> anotherListOfInstructors = Arrays.asList(arrayFromList);

		for(int i = 0; i < arrayFromList.length; i++){

			System.out.println("Index: " + i + ": " + anotherListOfInstructors.get(i));
		}

		System.out.println("####################");
		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		System.out.println("Before sort: ");
		for(int i = 0; i < instructors.size(); i++){

			System.out.println("Index: " + i + ": " + instructors.get(i));
		}

		Collections.sort(instructors);

		System.out.println("After sort: ");
		for(int i = 0; i < instructors.size(); i++){

			System.out.println("Index: " + i + ": " + instructors.get(i));
		}



		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(instructors);

		System.out.println("After reverse: ");
		for(int i = 0; i < instructors.size(); i++){

			System.out.println("Index: " + i + ": " + instructors.get(i));
		}

		Collections.reverse(instructors);

		System.out.println("After second reverse: ");
		for(int i = 0; i < instructors.size(); i++){

			System.out.println("Index: " + i + ": " + instructors.get(i));
		}

		//This doesn't work with primitive data types ;(
		// List<int> numbers = new ArrayList<int>();

		Integer employees = 23;
		Integer piecesOfCake = Integer.valueOf("24");

		if(employees > piecesOfCake){
			System.out.println("Burn everything.");
		}
		if(employees <= piecesOfCake){
			System.out.println("Party time!!.");
		}

		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++){
			numbers.add(i);
		}

		for (int i = 0; i < numbers.size(); i++){
			System.out.println(numbers.get(i));
		}


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		//use a for each loop to loop over the instructors list and print out their
		//name plus a greeting.

		for(String currentInstructorInList : instructors){
			if(currentInstructorInList.equals("Matt")){
				System.out.println(currentInstructorInList + ", get back to work!!");
			}

		}
	}
}
