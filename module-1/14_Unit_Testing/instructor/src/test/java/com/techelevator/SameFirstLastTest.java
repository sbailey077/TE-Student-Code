package com.techelevator;

import org.junit.*;

public class SameFirstLastTest {

    private SameFirstLast target;

    @Before
    public void setup() {
        target = new SameFirstLast();
    }

    /*
        Things to Test
             IsItTheSame([1, 2, 3]) → false
             IsItTheSame([1, 2, 3, 1]) → true
             IsItTheSame([1, 2, 1]) → true
             IsItTheSame([-1, -2, -1]) -> true
             IsItTheSame([]) -> false
             IsItTheSame([1]) -> true
             IsItTheSame(null) -> false
     */

    @Test
    public void is_not_same_first_and_last() {
        // Arrange
        int[] nums = new int[] { 1, 2, 3};

        // Act
        boolean actualResult = target.isItTheSame(nums);

        // Assert
        Assert.assertFalse(actualResult);
    }

}
