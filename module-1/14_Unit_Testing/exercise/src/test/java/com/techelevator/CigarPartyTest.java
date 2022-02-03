package com.techelevator;

import org.junit.*;

public class CigarPartyTest {

    private CigarParty target;

    @Before
    public void setup() {
        target = new CigarParty();
    }

    /*
        Things to Test
            haveParty(30, false) → false X
            haveParty(50, false) → true X
            haveParty(70, true) → true X
            haveParty(30, true) -> false X
            haveParty(60, false) -> true X
            haveParty(80, false) -> false X
            haveParty(40, false) -> true X
            haveParty(40, true) -> true X
            haveParty(0, false) -> false X
     */

    @Test
    public void under_40_not_weekend() {
        //Arrange
        int cigars = 30;
        boolean isWeekend = false;
        //Act
        boolean actualResult = target.haveParty(cigars, isWeekend);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void within_range_not_weekend() {
        //Arrange
        int cigars = 50;
        boolean isWeekend = false;
        //Act
        boolean actualResult = target.haveParty(cigars, isWeekend);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void above_60_is_weekend() {
        //Arrange
        int cigars = 70;
        boolean isWeekend = true;
        //Act
        boolean actualResult = target.haveParty(cigars, isWeekend);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void under_40_is_weekend() {
        //Arrange
        int cigars = 30;
        boolean isWeekend = true;
        //Act
        boolean actualResult = target.haveParty(cigars, isWeekend);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void is_60_is_weekend() {
        //Arrange
        int cigars = 60;
        boolean isWeekend = true;
        //Act
        boolean actualResult = target.haveParty(cigars, isWeekend);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void above_60_not_weekend() {
        //Arrange
        int cigars = 80;
        boolean isWeekend = false;
        //Act
        boolean actualResult = target.haveParty(cigars, isWeekend);
        //Assert
        Assert.assertFalse(actualResult);
    }

    @Test
    public void is_40_not_weekend() {
        //Arrange
        int cigars = 40;
        boolean isWeekend = false;
        //Act
        boolean actualResult = target.haveParty(cigars, isWeekend);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void is_40_is_weekend() {
        //Arrange
        int cigars = 40;
        boolean isWeekend = true;
        //Act
        boolean actualResult = target.haveParty(cigars, isWeekend);
        //Assert
        Assert.assertTrue(actualResult);
    }

    @Test
    public void is_0_not_weekend() {
        //Arrange
        int cigars = 0;
        boolean isWeekend = false;
        //Act
        boolean actualResult = target.haveParty(cigars, isWeekend);
        //Assert
        Assert.assertFalse(actualResult);
    }
}
