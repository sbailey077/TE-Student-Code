package com.techelevator;

import org.junit.*;

public class MaxEnd3Test {

    private MaxEnd3 target;

    @Before
    public void setup() {
        target = new MaxEnd3();
    }

    /*
        Things to Test
            MakeArray([1, 2, 3]) → [3, 3, 3] X
            MakeArray([11, 5, 9]) → [11, 11, 11] X
            MakeArray([2, 11, 3]) → [3, 3, 3] X
            MakeArray([0, 0, 0]) -> [0, 0, 0] X
            MakeArray([2, 4, 2]) -> [2, 2, 2]
     */

    @Test
    public void last_is_biggest() {
        //Arrange
        int [] nums = new int[] {1, 2, 3};
        int [] expectedResult = new int[] {3, 3, 3};
        //Act
        int [] actualResult = target.makeArray(nums);
        //Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void first_is_biggest() {
        //Arrange
        int [] nums = new int[] {11, 5, 9};
        int [] expectedResult = new int[] {11, 11, 11};
        //Act
        int [] actualResult = target.makeArray(nums);
        //Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void last_is_biggest_larger_middle() {
        //Arrange
        int [] nums = new int[] {2, 11, 3};
        int [] expectedResult = new int[] {3, 3, 3};
        //Act
        int [] actualResult = target.makeArray(nums);
        //Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void all_3_same_size() {
        //Arrange
        int [] nums = new int[] {0, 0, 0};
        int [] expectedResult = new int[] {0, 0, 0};
        //Act
        int [] actualResult = target.makeArray(nums);
        //Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void first_and_last_same_size() {
        //Arrange
        int [] nums = new int[] {2, 4, 2};
        int [] expectedResult = new int[] {2, 2, 2};
        //Act
        int [] actualResult = target.makeArray(nums);
        //Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }
}
