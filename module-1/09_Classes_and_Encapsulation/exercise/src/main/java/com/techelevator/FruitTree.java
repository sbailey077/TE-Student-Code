package com.techelevator;

public class FruitTree {

    /*
    Member Variables:
        typeOfFruit - determines the type of fruit on the tree
        piecesOfFruitLeft - determines how many remaining pieces of fruit are on the tree
     */

    private int piecesOfFruitLeft;
    private String typeOfFruit;

    /*
    Constructor
     */

    public FruitTree (String typeOfFruit, int startingPiecesOfFruit) {
        this.piecesOfFruitLeft = startingPiecesOfFruit;
        this.typeOfFruit = typeOfFruit;
    }

    /*
    Getters
     */

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    /*
    Method
     */

    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        } else {
            return false;
        }
    }

}
