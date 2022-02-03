package com.techelevator;

import org.junit.*;

public class FrontTimesTest {

    private FrontTimes target;

    @Before
    public void setup() {
        target = new FrontTimes();
    }

    /*
        Things to Test
            FrontTimes(Chocolate, 2) X
            FrontTimes(Chocolate, 3) X
            FrontTimes(abc, 1) X
            FrontTimes(Ab, 2) X
            FrontTimes(A, 4) X
            FrontTimes(Abc, 0) X
            FrontTimes(null)
            FrontTimes("", 2) X
     */

    @Test
    public void chocolate_2() {
        //Arrange
        String str = "Chocolate";
        int n = 2;
        String expectedResult = "ChoCho";
        //Act
        String actualResult = target.generateString(str, n);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void chocolate_3() {
        //Arrange
        String str = "Chocolate";
        int n = 3;
        String expectedResult = "ChoChoCho";
        //Act
        String actualResult = target.generateString(str, n);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void abc_1() {
        //Arrange
        String str = "abc";
        int n = 1;
        String expectedResult = "abc";
        //Act
        String actualResult = target.generateString(str, n);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void ab_2() {
        //Arrange
        String str = "Ab";
        int n = 2;
        String expectedResult = "AbAb";
        //Act
        String actualResult = target.generateString(str, n);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void a_4() {
        //Arrange
        String str = "A";
        int n = 4;
        String expectedResult = "AAAA";
        //Act
        String actualResult = target.generateString(str, n);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void abc_0() {
        //Arrange
        String str = "Abc";
        int n = 0;
        String expectedResult = "";
        //Act
        String actualResult = target.generateString(str, n);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void is_null() {
        //Arrange
        String str = null;
        int n = 2;
        String expectedResult = "";
        //Act
        String actualResult = target.generateString(str, n);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void empty_string() {
        //Arrange
        String str = "";
        int n = 2;
        String expectedResult = "";
        //Act
        String actualResult = target.generateString(str, n);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
