package com.techelevator.tollbooth;

public class Tank implements Vehicle {

    @Override
    public double calculateToll(int distance) {
        return 0;
    }

    @Override
    public String toString() {
        return "Tank";
    }
}
