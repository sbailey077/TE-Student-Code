package com.techelevator.exercises;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    The test class should be in the same package as the class it is testing and named the same with a
    Test suffix.
 */
public class SleepInTest {

    /*
        Create a private variable to hold the reference to the object we are testing
     */
    private SleepIn target;

    /*
        The @Before annotation tells JUnit to run this method before every test
     */
    @Before
    public void setup() {
        target = new SleepIn();
    }

    /*
        The @After annotation tells JUnit to run this method after every test

        There is often not a need for @After so it can be omitted.
     */
    @After
    public void cleanup() {
        // This code will run after every test
        System.out.println();
    }

    /*
        Weekday    Vacation       expected SleepIn?
        false       false           true
        false       true            true
        true        false           false
        true        true            true
     */

    @Test
    public void weekday_false_and_vacation_false() {
        // 1) Arrange  (Setup) - prepare the class for testing.  Sometimes not needed
        // 2) Act (Test)
        boolean actualResult = target.sleepIn(false, false);
        // 3) Assert (Verify) - verify the results are what we expect
        Assert.assertTrue("Result was false when expected true", actualResult);
    }

    @Test
    public void weekday_false_and_vacation_true() {
        // Arrange
        // Act
        boolean didWeSleepIn = target.sleepIn(false, true);
        // Assert
        Assert.assertTrue(didWeSleepIn);
    }

    @Test
    public void weekday_true_and_vacation_false() {
        // Arrange
        // Act
        boolean didWeSleepIn = target.sleepIn(true, false);
        // Assert
        Assert.assertFalse(didWeSleepIn);
    }

    @Test
    public void weekday_true_and_vacation_true() {
        // Arrange
        // Act
        boolean didWeSleepIn = target.sleepIn(true, true);
        // Assert
        Assert.assertTrue(didWeSleepIn);
    }
}
