package com.techelevator;

import org.junit.*;

import java.util.HashMap;
import java.util.Map;

public class AnimalGroupNameTest {


    private AnimalGroupName target;

    @Before
    public void setup() {
        target = new AnimalGroupName();
    }

    /*
        Things to Test
            AnimalGroupName(Rhino) -> Crash X
            AnimalGroupName(ELEPHANT) -> Herd X
            AnimalGroupName(flamingo) -> Pat X
            AnimalGroupName(PiGeOn) -> Kit X
            AnimalGroupName("") -> unknown X
            AnimalGroupName(Walrus) -> unknown X
            AnimalGroupName(null) -> unknown X
     */

    @Test
    public void first_letter_capital() {
        //Arrange
        String name = "Rhino";
        String herdName = "Crash";
        //Act
        String actualResult = target.getHerd(name);
        //Assert
        Assert.assertEquals(actualResult, herdName);
    }

    @Test
    public void all_capital() {
        //Arrange
        String name = "ELEPHANT";
        String herdName = "Herd";
        //Act
        String actualResult = target.getHerd(name);
        //Assert
        Assert.assertEquals(actualResult, herdName);
    }

    @Test
    public void all_lowercase() {
        //Arrange
        String name = "flamingo";
        String herdName = "Pat";
        //Act
        String actualResult = target.getHerd(name);
        //Assert
        Assert.assertEquals(actualResult, herdName);
    }

    @Test
    public void mixed_capitals() {
        //Arrange
        String name = "Pigeon";
        String herdName = "Kit";
        //Act
        String actualResult = target.getHerd(name);
        //Assert
        Assert.assertEquals(actualResult, herdName);
    }

    @Test
    public void empty_string() {
        //Arrange
        String name = "";
        String herdName = "unknown";
        //Act
        String actualResult = target.getHerd(name);
        //Assert
        Assert.assertEquals(actualResult, herdName);
    }

    @Test
    public void walrus() {
        //Arrange
        String name = "Walrus";
        String herdName = "unknown";
        //Act
        String actualResult = target.getHerd(name);
        //Assert
        Assert.assertEquals(actualResult, herdName);
    }

    @Test
    public void null_test() {
        //Arrange
        String name = null;
        String herdName = "unknown";
        //Act
        String actualResult = target.getHerd(name);
        //Assert
        Assert.assertEquals(actualResult, herdName);
    }
}
