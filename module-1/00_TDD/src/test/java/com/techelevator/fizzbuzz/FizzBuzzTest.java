package com.techelevator.fizzbuzz;

import org.junit.*;

/*
    TESTS
    -multiple of 3 that is not a multiple 5
    -multiple of 5 that is not a multiple 3
    -multiple of 3 and 5
    -not a multiple of 3 or 5

    0
    -negative number (-1, 1, -18, -20, -15)
 */
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void multiple_of_3_but_not_5() {
        Assert.assertEquals("Fizz", fizzBuzz.fizzBuzzIt(9));
        Assert.assertEquals("Fizz", fizzBuzz.fizzBuzzIt(-18));
    }

    @Test
    public void multiple_of_5_but_not_3() {
        Assert.assertEquals("Buzz", fizzBuzz.fizzBuzzIt(10));
        Assert.assertEquals("Buzz", fizzBuzz.fizzBuzzIt(-20));
    }

    @Test
    public void multiple_of_3_and_5() {
        Assert.assertEquals("FizzBuzz", fizzBuzz.fizzBuzzIt(15));
        Assert.assertEquals("FizzBuzz", fizzBuzz.fizzBuzzIt(15));
    }

    @Test
    public void not_multiple_of_3_or_5() {
        Assert.assertEquals("17", fizzBuzz.fizzBuzzIt(17));
        Assert.assertEquals("-1", fizzBuzz.fizzBuzzIt(-1));
    }

    @Test
    public void value_of_zero() {
        Assert.assertEquals("FizzBuzz", fizzBuzz.fizzBuzzIt(0));
    }
}
