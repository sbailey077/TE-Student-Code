package com.techelevator;

import org.junit.*;

public class MovieRentalTest {

    private MovieRental target;

    @Before
    public void setup() {
        target = new MovieRental("The Shawshank Redemption", "DVD", false);
    }

    /*
        Things to Test
          rental price calculation: VHS(no), DVD(no), BluRay(no), vhs(yes), dvd(yes), bluray(yes)
          late fee calculation: 0, 1, 2, 3, 7, -1

     */

    @Test
    public void late_fee_0() {
        //Arrange
        int i = 0;
        double expectedResult = 0.00;
        //Act
        double actualResult = target.determineLateFee(i);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void late_fee_1() {
        //Arrange
        int i = 1;
        double expectedResult = 1.99;
        //Act
        double actualResult = target.determineLateFee(i);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void late_fee_2() {
        //Arrange
        int i = 2;
        double expectedResult = 3.99;
        //Act
        double actualResult = target.determineLateFee(i);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void late_fee_3() {
        //Arrange
        int i = 3;
        double expectedResult = 19.99;
        //Act
        double actualResult = target.determineLateFee(i);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void late_fee_7() {
        //Arrange
        int i = 7;
        double expectedResult = 19.99;
        //Act
        double actualResult = target.determineLateFee(i);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void late_fee_neg_1() {
        //Arrange
        int i = -1;
        double expectedResult = 0.00;
        //Act
        double actualResult = target.determineLateFee(i);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void VHS_not_premium() {
        //Arrange
        String format = "VHS";
        double expectedResult = 0.99;
        //Act
        double actualResult = target.determineRentalPrice(format, false);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void DVD_not_premium() {
        //Arrange
        String format = "DVD";
        double expectedResult = 1.99;
        //Act
        double actualResult = target.determineRentalPrice(format, false);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void BluRay_not_premium() {
        //Arrange
        String format = "BluRay";
        double expectedResult = 2.99;
        //Act
        double actualResult = target.determineRentalPrice(format, false);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void vhs_premium() {
        //Arrange
        String format = "vhs";
        double expectedResult = 1.99;
        //Act
        double actualResult = target.determineRentalPrice(format, true);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void dvd_premium() {
        //Arrange
        String format = "dvd";
        double expectedResult = 2.99;
        //Act
        double actualResult = target.determineRentalPrice(format, true);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);
    }

    @Test
    public void bluray_premium() {
        //Arrange
        String format = "bluray";
        double expectedResult = 3.99;
        //Act
        double actualResult = target.determineRentalPrice(format, true);
        //Assert
        Assert.assertEquals(expectedResult, actualResult, 0.005);

    }

}



