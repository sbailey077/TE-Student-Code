package com.techelevator;

import org.junit.*;

public class DateFashionTest {

    private DateFashion target;

    @Before
    public void setup() {
        target = new DateFashion();
    }

    /*
        Things to Test
            dateFashion(5, 10) → 2 X
            dateFashion(5, 2) → 0 X
            dateFashion(5, 5) → 1 X
            dateFashion(8, 2) -> 0 X
            dateFashion(0, 1) -> 0 X
            dateFashion(9, 3) -> 2 X
            dateFashion(2, 7) -> 0 X
            dateFashion(7, 3) -> 1 X
     */
    @Test
    public void you_5_date_10(){
        //Arrange
        int yourNumber = 5;
        int dateNumber = 10;
        int expectedResult = 2;
        //Act
        int actualResult = target.getATable(yourNumber, dateNumber);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void you_5_date_2(){
        //Arrange
        int yourNumber = 5;
        int dateNumber = 2;
        int result = 0;
        //Act
        int actualResult = target.getATable(yourNumber, dateNumber);
        //Assert
        Assert.assertEquals(actualResult, result);
    }

    @Test
    public void you_5_date_5(){
        //Arrange
        int yourNumber = 5;
        int dateNumber = 5;
        int result = 1;
        //Act
        int actualResult = target.getATable(yourNumber, dateNumber);
        //Assert
        Assert.assertEquals(actualResult, result);
    }

    @Test
    public void you_8_date_2(){
        //Arrange
        int yourNumber = 8;
        int dateNumber = 2;
        int result = 0;
        //Act
        int actualResult = target.getATable(yourNumber, dateNumber);
        //Assert
        Assert.assertEquals(actualResult, result);
    }

    @Test
    public void you_0_date_1(){
        //Arrange
        int yourNumber = 0;
        int dateNumber = 1;
        int result = 0;
        //Act
        int actualResult = target.getATable(yourNumber, dateNumber);
        //Assert
        Assert.assertEquals(actualResult, result);
    }

    @Test
    public void you_9_date_3(){
        //Arrange
        int yourNumber = 9;
        int dateNumber = 3;
        int result = 2;
        //Act
        int actualResult = target.getATable(yourNumber, dateNumber);
        //Assert
        Assert.assertEquals(actualResult, result);
    }

    @Test
    public void you_2_date_7(){
        //Arrange
        int yourNumber = 2;
        int dateNumber = 7;
        int result = 0;
        //Act
        int actualResult = target.getATable(yourNumber, dateNumber);
        //Assert
        Assert.assertEquals(actualResult, result);
    }


    @Test
    public void you_7_date_3(){
        //Arrange
        int yourNumber = 7;
        int dateNumber = 3;
        int result = 1;
        //Act
        int actualResult = target.getATable(yourNumber, dateNumber);
        //Assert
        Assert.assertEquals(actualResult, result);
    }
}
