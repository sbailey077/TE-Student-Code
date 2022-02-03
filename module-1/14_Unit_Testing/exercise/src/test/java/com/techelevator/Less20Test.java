package com.techelevator;

import org.junit.*;

public class Less20Test {

    private Less20 target;

    @Before
    public void setup() {
        target = new Less20();
    }

    /*
        Things to Test
            less20(18) → true X
            less20(19) → true X
            less20(20) → false X
            less20(0) -> false X
            less20(21) -> false X
            less20(38) -> true X
            less20(39) -> true X
            less20(40) -> false X
     */

    @Test
    public void eighteen() {
        //Arrange
        int n = 18;
        //Act
        boolean actualResult = target.isLessThanMultipleOf20(n);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void nineteen() {
        //Arrange
        int n = 19;
        //Act
        boolean actualResult = target.isLessThanMultipleOf20(n);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void twenty() {
        //Arrange
        int n = 20;
        //Act
        boolean actualResult = target.isLessThanMultipleOf20(n);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void zero() {
        //Arrange
        int n = 0;
        //Act
        boolean actualResult = target.isLessThanMultipleOf20(n);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void twenty_one() {
        //Arrange
        int n = 21;
        //Act
        boolean actualResult = target.isLessThanMultipleOf20(n);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void thirty_eight() {
        //Arrange
        int n = 38;
        //Act
        boolean actualResult = target.isLessThanMultipleOf20(n);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void thirty_nine() {
        //Arrange
        int n = 39;
        //Act
        boolean actualResult = target.isLessThanMultipleOf20(n);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void forty() {
        //Arrange
        int n = 40;
        //Act
        boolean actualResult = target.isLessThanMultipleOf20(n);
        //Assert
        Assert.assertFalse(actualResult);
    }
}
