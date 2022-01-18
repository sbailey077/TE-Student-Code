package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;
		System.out.println(numberOfExercises);



		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = 0.5;
		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".

			\t - prints a tab character
			\n - prints a newline
			\" - prints a double quote as character instead of part of Java syntax
		*/
		String name = "\t\"Tech\nElevator\"";
		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		short seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.

			literal floating numbers (3.14) default to double
			3.14f - f tells Java we want the number to be a float
		*/
		double pi = 3.1416;
		float piAsFloat = 3.1416f;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String yourName = "Your Name";
		System.out.println(yourName);

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfButtonsOnMouse = 3;

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		byte phoneBatteryPercentage = 80;

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121 - 27;
		System.out.println(difference);

		int firstNumber = 200;
		int secondNumber = 50;
		int differenceBetweenNumbers = firstNumber - secondNumber;
		System.out.println(differenceBetweenNumbers);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double sumOfDoubles = 12.3 + 32.1;
		System.out.println(sumOfDoubles);
		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Rachelle Rauh";
		System.out.println(fullName);
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String greeting = "Hello, " + fullName;
		System.out.println(greeting);
		System.out.println(fullName);
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire";
		System.out.println(fullName);
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		String fullNameTwo = "John Fulton";
		fullNameTwo += " Esquire";
		System.out.println(fullNameTwo);

		int number = 10;
		number /= 5;
		System.out.println(number);

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String saw = "Saw" + 2;
		System.out.println(saw);

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		saw = saw + 0;
		System.out.println(saw);

		long longX = 10;
		int intX = (int) longX;

		int intY = 10;
		long longY = intY;

		/*
		18. What is 4.4 divided by 2.2?
		*/
		System.out.println("18: " + 4.4 / 2.2);
		/*
		19. What is 5.4 divided by 2?
		*/
		double one19 = 5.4;
		int two19 = 2;
		System.out.println(one19 / two19);

		/*
		20. What is 5 divided by 2?
		*/
		double result20 = 5 / 2;
		System.out.println(result20);

		/*
		21. What is 5.0 divided by 2?
		*/
		double result21 = 5.0 / 2;
		System.out.println(result21);

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println(66.6 / 100);

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		int remainder = 5 % 2;
		System.out.println(remainder);

		/*
		24. What is 1,000,000,000 * 3?
		*/
		int tooLargeOfNumber = 1000000000 * 3;
		System.out.println(tooLargeOfNumber);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean isDoneWithExercises = false;
		System.out.println(isDoneWithExercises);
		/*
		26. Now set doneWithExercise to true.
		*/
		isDoneWithExercises = true;
		System.out.println(isDoneWithExercises);


		/*
			Print percentageOfBattery with a percent sign
		 */
		System.out.println(phoneBatteryPercentage + "%");
	}

}
