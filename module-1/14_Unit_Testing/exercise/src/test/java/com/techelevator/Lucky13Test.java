package com.techelevator;

import org.junit.*;

public class Lucky13Test {

    private Lucky13 target;

    @Before
    public void setup() {
        target = new Lucky13();
    }

    /*
        Things to Test
            GetLucky([0, 2, 4]) → true X
            GetLucky([1, 2, 3]) → false X
            GetLucky([1, 2, 4]) → false X
            GetLucky(null) -> true X
            GetLucky([0, 2, 3, 5]) -> false X
            GetLucky([2]) -> true X
            GetLucky([2, 4]) -> true X
            GetLucky([3, 3]) -> false X
            GetLucky([1]) -> false
     */

    @Test
    public void length_3_no_1_no_3() {
        //Arrange
        int [] nums = new int [] {0, 2, 4};
        //Act
        boolean actualResult = target.getLucky(nums);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void length_3_has_1_has_3() {
        //Arrange
        int [] nums = new int [] {1, 2, 3};
        //Act
        boolean actualResult = target.getLucky(nums);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void length_3_has_1_no_3() {
        //Arrange
        int [] nums = new int [] {1, 2, 4};
        //Act
        boolean actualResult = target.getLucky(nums);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void is_null() {
        //Arrange
        int [] nums = null;
        //Act
        boolean actualResult = target.getLucky(nums);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void length_5_no_1_has_3() {
        //Arrange
        int [] nums = new int [] {0, 2, 3, 5};
        //Act
        boolean actualResult = target.getLucky(nums);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void length_1_no_1_no_3() {
        //Arrange
        int [] nums = new int [] {2};
        //Act
        boolean actualResult = target.getLucky(nums);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void length_2_no_1_no_3() {
        //Arrange
        int [] nums = new int [] {2, 4};
        //Act
        boolean actualResult = target.getLucky(nums);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void length_2_no_1_double_3() {
        //Arrange
        int [] nums = new int [] {3, 3};
        //Act
        boolean actualResult = target.getLucky(nums);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void length_1_has_1_no_3() {
        //Arrange
        int [] nums = new int [] {1};
        //Act
        boolean actualResult = target.getLucky(nums);
        //Assert
        Assert.assertFalse(actualResult);
    }
}
