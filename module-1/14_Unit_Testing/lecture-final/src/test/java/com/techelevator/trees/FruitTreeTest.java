package com.techelevator.trees;

import org.junit.*;

public class FruitTreeTest {

    private FruitTree fruitTree;

    @Before
    public void createFruitTree() {
        fruitTree = new FruitTree("Apple", 10);
    }

    /*
        X Test the Getters - getTypeOfFruit() returns Apple
        X                    getPiecesOfFruitLeft return 10

        Xpick some fruit
        Xpick too much fruit
        Xpick zero fruit
        Xpick negative fruit
        Xpick all fruit
        Xpick fruit twice
        Xpick some fruit, then pick the rest
        Xpick some fruit, then pick too much

     */

    @Test
    public void get_type_of_fruit() {
        Assert.assertEquals("Apple", fruitTree.getTypeOfFruit());
    }

    @Test
    public void get_pieces_of_fruit_remaining() {
        Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_some_fruit() {
        // Arrange
        int amountToPick = 4;
        // Act
        boolean ableToPickFruit = fruitTree.pickFruit(amountToPick);
        // Assert
        Assert.assertTrue(ableToPickFruit);
        int actualFruitLeftOnTree = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(6, actualFruitLeftOnTree);
    }

    @Test
    public void pick_too_much_fruit() {
        // Arrange
        int amountToPick = 11;
        // Act
        boolean ableToPickFruit = fruitTree.pickFruit(amountToPick);
        // Assert
        Assert.assertFalse(ableToPickFruit);
        int actualFruitLeftOnTree = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(10, actualFruitLeftOnTree);
    }

    @Test
    public void pick_zero_fruit() {
        // Arrange
        int amountToPick = 0;
        // Act
        boolean ableToPickFruit = fruitTree.pickFruit(amountToPick);
        // Assert
        Assert.assertTrue(ableToPickFruit);
        int actualFruitLeftOnTree = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(10, actualFruitLeftOnTree);
    }

    @Test
    public void pick_negative_fruit() {
        // Arrange
        int amountToPick = -1;
        // Act
        boolean ableToPickFruit = fruitTree.pickFruit(amountToPick);
        // Assert
        Assert.assertFalse("Was able to pick fruit", ableToPickFruit);
        int actualFruitLeftOnTree = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals("Wrong number of fruit remaining", 10, actualFruitLeftOnTree);
    }

    @Test
    public void pick_all_the_fruit() {
        // Arrange
        int amountToPick = 10;
        // Act
        boolean ableToPickFruit = fruitTree.pickFruit(amountToPick);
        // Assert
        Assert.assertTrue(ableToPickFruit);
        int actualFruitLeftOnTree = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals("Wrong number of fruit remaining", 0, actualFruitLeftOnTree);
    }

    @Test
    public void pick_fruit_multiple_times() {
        // Arrange
        int firstPick = 2;
        int secondPick = 4;
        fruitTree.pickFruit(firstPick);

        // Act
        boolean ableToPickFruit = fruitTree.pickFruit(secondPick);

        // Assert
        Assert.assertTrue(ableToPickFruit);
        int actualFruitLeftOnTree = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals("Wrong number of fruit remaining", 4, actualFruitLeftOnTree);

    }

    @Test
    public void pick_fruit_all_remaining_on_second_pick() {
        // Arrange
        int firstPick = 2;
        int secondPick = 8;
        fruitTree.pickFruit(firstPick);

        // Act
        boolean ableToPickFruit = fruitTree.pickFruit(secondPick);

        // Assert
        Assert.assertTrue(ableToPickFruit);
        int actualFruitLeftOnTree = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals("Wrong number of fruit remaining", 0, actualFruitLeftOnTree);

    }

    @Test
    public void pick_fruit_the_too_many_on_second_pick() {
        // Arrange
        int firstPick = 2;
        int secondPick = 9;
        fruitTree.pickFruit(firstPick);

        // Act
        boolean ableToPickFruit = fruitTree.pickFruit(secondPick);

        // Assert
        Assert.assertFalse(ableToPickFruit);
        int actualFruitLeftOnTree = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals("Wrong number of fruit remaining", 8, actualFruitLeftOnTree);

    }
}
