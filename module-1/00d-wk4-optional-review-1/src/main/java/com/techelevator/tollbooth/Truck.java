package com.techelevator.tollbooth;

public class Truck implements Vehicle {

    private int numberOfAxles;

    public Truck(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    @Override
    public double calculateToll(int distance) {
        double toll = 0;
        if (numberOfAxles == 4) {
            toll = distance * 0.040;
        } else if (numberOfAxles == 6) {
            toll = distance * 0.045;
        } else if (numberOfAxles >= 8) {
            toll = distance * 0.048;
        }
        return toll;
    }

    @Override
    public String toString() {
        return "Truck (" + numberOfAxles + " axels)";
    }
}
