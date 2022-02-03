package com.techelevator;

import org.junit.*;

public class NonStartTest {

    private NonStart target;

    @Before
    public void setup() {
        target = new NonStart();
    }

    /*
        Things to Test
            GetPartialString("Hello", "There") → "ellohere" X
            GetPartialString("java", "code") → "avaode" X
            GetPartialString("shotl", "java") → "hotlava" X
            GetPartialString("OspIn", "pDocToR") -> "spInDocToR" X
            GetPartialString("a", "y") -> "" X
            GetPartialString("gi", "os") -> "is" X
     */

    @Test
    public void hello_there() {
        //Arrange
        String a = "Hello";
        String b = "There";
        String expectedResult = "ellohere";
        //Act
        String actualResult = target.getPartialString(a, b);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void java_code() {
        //Arrange
        String a = "java";
        String b = "code";
        String expectedResult = "avaode";
        //Act
        String actualResult = target.getPartialString(a, b);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shotl_java() {
        //Arrange
        String a = "shotl";
        String b = "java";
        String expectedResult = "hotlava";
        //Act
        String actualResult = target.getPartialString(a, b);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void capital_check() {
        //Arrange
        String a = "OspIn";
        String b = "pDocToR";
        String expectedResult = "spInDocToR";
        //Act
        String actualResult = target.getPartialString(a, b);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void single_letter() {
        //Arrange
        String a = "a";
        String b = "y";
        String expectedResult = "";
        //Act
        String actualResult = target.getPartialString(a, b);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void two_letters() {
        //Arrange
        String a = "ay";
        String b = "be";
        String expectedResult = "ye";
        //Act
        String actualResult = target.getPartialString(a, b);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
