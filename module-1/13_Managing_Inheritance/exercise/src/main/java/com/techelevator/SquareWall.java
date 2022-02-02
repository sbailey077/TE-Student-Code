package com.techelevator;

import java.lang.invoke.SwitchPoint;

public class SquareWall extends RectangleWall {

    private int sideLength;

    public SquareWall (String name, String color, int sideLength) {
        super(name, color, sideLength, sideLength);
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return getName() + " (" + sideLength + "x" + sideLength + ") square";
    }
}
