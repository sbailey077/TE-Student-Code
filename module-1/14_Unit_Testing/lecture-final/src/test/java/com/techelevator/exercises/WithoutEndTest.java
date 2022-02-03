package com.techelevator.exercises;

import org.junit.*;

public class WithoutEndTest {

    private WithoutEnd target;

    @Before
    public void setup() {
        target = new WithoutEnd();
    }

    /*
        Tests
        Hello -> ell
        abc -> b
        ab -> ""
        a -> ""
        null -> ""
        "" -> ""
     */

    @Test
    public void hello_returns_ell() {
        // Arrange
        // Act (Test)
        String actualResult = target.withoutEnd("Hello");
        // Assert
        // assertEquals( expectedValue, actualValue )
        Assert.assertEquals( "ell", actualResult);
    }

    @Test
    public void abc_returns_b() {
        // Arrange
        // Act
        String actualResult = target.withoutEnd("abc");
        // Assert
        Assert.assertEquals("b", actualResult);
    }

    @Test
    public void two_letters_return_empty_string() {
        // Arrange
        // Act & Assert
        Assert.assertEquals("", target.withoutEnd("ab"));
    }

    @Test
    public void one_letter_returns_empty_string() {
        Assert.assertEquals("", target.withoutEnd("a"));
    }

    @Test
    public void null_returns_empty_string() {
        Assert.assertEquals("", target.withoutEnd(null));
    }

    @Test
    public void empty_returns_empty_string() {
        Assert.assertEquals("", target.withoutEnd(""));
    }



}
