package com.techelevator;

import org.junit.*;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    private WordCount target;

    @Before
    public void setup() {
        target = new WordCount();
    }

    /*
        Things to Test
            getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	        getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
	        getCount([]) → {}
	        getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
	        getCount(["a", "a", "a", "a"]) -> {"a": 4}
	        getCount([null]) -> null
     */

    @Test
    public void ba_ba_black_sheep() {
        //Arrange
        Integer baCount = 2;
        Integer blackCount = 1;
        Integer sheepCount = 1;
        String [] stringArray = new String[] {"ba", "ba", "black", "sheep"};
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put(stringArray[0], baCount);
        expectedResult.put(stringArray[2], blackCount);
        expectedResult.put(stringArray[3], sheepCount);
        //Act
        Map<String, Integer> actualResult = target.getCount(stringArray);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void a_b_a_c_b() {
        //Arrange
        Integer aCount = 2;
        Integer bCount = 2;
        Integer cCount = 1;
        String [] stringArray = new String[] {"a", "b", "a", "c", "b"};
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put(stringArray[0], aCount);
        expectedResult.put(stringArray[1], bCount);
        expectedResult.put(stringArray[3], cCount);
        //Act
        Map<String, Integer> actualResult = target.getCount(stringArray);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void empty_array() {
        //Arrange
        String [] stringArray = new String[] {};
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        //Act
        Map<String, Integer> actualResult = target.getCount(stringArray);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void c_b_a() {
        //Arrange
        Integer aCount = 1;
        Integer bCount = 1;
        Integer cCount = 1;
        String [] stringArray = new String[] {"c", "b", "a"};
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put(stringArray[0], cCount);
        expectedResult.put(stringArray[1], bCount);
        expectedResult.put(stringArray[2], aCount);
        //Act
        Map<String, Integer> actualResult = target.getCount(stringArray);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void four_a() {
        //Arrange
        Integer aCount = 4;
        String [] stringArray = new String[] {"a", "a", "a", "a"};
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put(stringArray[0], aCount);
        //Act
        Map<String, Integer> actualResult = target.getCount(stringArray);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void is_null() {
        //Arrange
        String [] stringArray = null;
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        //Act
        Map<String, Integer> actualResult = target.getCount(stringArray);
        //Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

}
