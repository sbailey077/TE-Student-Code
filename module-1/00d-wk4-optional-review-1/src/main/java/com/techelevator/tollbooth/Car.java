package com.techelevator.tollbooth;

public class Car implements Vehicle {

    private boolean hasTrailer;

    public Car(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }

    @Override
    public double calculateToll(int distance) {
        double toll = distance * 0.020;
        if (hasTrailer) {
            toll += 1;
        }
        return toll;
    }

    @Override
    public String toString() {
        String str = "Car";
        if (hasTrailer) {
            str += " (with trailer)";
        }
        return str;
    }
}
