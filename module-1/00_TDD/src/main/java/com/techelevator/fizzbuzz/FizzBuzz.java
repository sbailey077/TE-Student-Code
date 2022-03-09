package com.techelevator.fizzbuzz;

public class FizzBuzz {

    /*
    Given a number
    Return Fizz if the number is a multiple of 3
    Return Buzz if the number is a multiple of 5
    Return FizzBuzz if the number is a multiple of both 3 and 5
    Otherwise return the original number
     */

    private final static int FIZZ_NUMBER = 3;
    private final static int BUZZ_NUMBER = 5;
    private final static String FIZZ_STRING = "Fizz";
    private final static String BUZZ_STRING = "Buzz";

    /**
     * Given a number returns Fizz if the number is a multiple of three, but not 5.
     * returns Buzz if the number is a multiple of 5, but not 3.
     * returns FizzBuzz if the number is a multiple of both 3 and 5
     * Otherwise returns the original number as a String
     *
     * @param number the number to check
     * @return a String result of the calculation
     */
    public String fizzBuzzIt(int number) {

        String result = "";

        if (isFizz(number)) {
            result += FIZZ_STRING;
        }
        if (isBuzz(number)) {
            result += BUZZ_STRING;
        }

        return makeFizzBuzzOrNumber(result, number);
    }

    private String makeFizzBuzzOrNumber(String result, int number) {
        return result.length() == 0 ? String.valueOf(number) : result;
    }

    private boolean isFizz(int number) {
        return number % FIZZ_NUMBER == 0;
    }

    private boolean isBuzz(int number) {
        return number % BUZZ_NUMBER == 0;
    }

}
