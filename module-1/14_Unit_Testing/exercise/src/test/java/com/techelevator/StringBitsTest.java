package com.techelevator;

import org.junit.*;

public class StringBitsTest {

    private StringBits target;

    @Before
    public void setup() {
        target = new StringBits();
    }

    /*
        Things to Test
            GetBits("Hello") → "Hlo"
            GetBits("Hi") → "H"
            GetBits("Heeololeo") → "Hello"
            GetBits("H") -> "H"
            GetBits("") -> ""
            GetBits("BaadGeecL") -> "BaGeL"
     */

    @Test
    public void hello() {
        //Arrange
        String str = "Hello";
        String expectedResult = "Hlo";
        //Act
        String actualResult = target.getBits(str);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void hi() {
        //Arrange
        String str = "Hi";
        String expectedResult = "H";
        //Act
        String actualResult = target.getBits(str);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void single_letter() {
        //Arrange
        String str = "H";
        String expectedResult = "H";
        //Act
        String actualResult = target.getBits(str);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void heeololeo() {
        //Arrange
        String str = "Heeololeo";
        String expectedResult = "Hello";
        //Act
        String actualResult = target.getBits(str);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void empty_string() {
        //Arrange
        String str = "";
        String expectedResult = "";
        //Act
        String actualResult = target.getBits(str);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void multiple_capitals() {
        //Arrange
        String str = "BaadGeecL";
        String expectedResult = "BaGeL";
        //Act
        String actualResult = target.getBits(str);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
