package com.techelevator;

import org.junit.*;

public class SameFirstLastTest {

    private SameFirstLast target;

    @Before
    public void setup () {
        target = new SameFirstLast();
    }

    /*
        Things to Test
        IsItTheSame ([1, 2, 3]) -> false X
        IsItTheSame ([1, 2, 3, 1]) -> true X
        IsItTheSame ([1, 2, 1]) -> true X
        IsItTheSame ([-1, -2, -1]) -> true X
        IsItTheSame ([null]) -> false X
        IsItTheSame ([]) -> false X
        IsItTheSame ([1]) -> true X

     */

    @Test
    public void first_and_last_are_not_equal() {
        //Arrange
        int[] nums = new int[] {1, 2, 3};
        //Act
        boolean actualResult = target.isItTheSame(nums);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void first_and_last_are_equal_length_4() {
        //Arrange
        int[] nums = new int[] {1, 2, 3, 1};
        //Act
        boolean actualResult = target.isItTheSame(nums);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void first_and_last_are_equal_length_3() {
        //Arrange
        int[] nums = new int[]{1, 2, 1};
        //Act
        boolean actualResult = target.isItTheSame(nums);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void first_and_last_are_equal_negative() {
        //Arrange
        int[] nums = new int[] {-1, -2, -1};
        //Act
        boolean actualResult = target.isItTheSame(nums);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void null_array() {
        //Arrange
        int[] nums = null;
        //Act
        boolean actualResult = target.isItTheSame(nums);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void empty_array() {
        //Arrange
        int[] nums = new int[] {};
        //Act
        boolean actualResult = target.isItTheSame(nums);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void first_and_last_are_equal_length_1() {
        //Arrange
        int[] nums = new int[] {1};
        //Act
        boolean actualResult = target.isItTheSame(nums);
        //Assert
        Assert.assertTrue(actualResult);
    }
}
