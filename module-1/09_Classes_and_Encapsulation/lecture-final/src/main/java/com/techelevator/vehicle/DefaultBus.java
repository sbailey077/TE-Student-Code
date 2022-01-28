package com.techelevator.vehicle;

/*
    This class is to demonstrate the most basic parts needed
    to define a class like the Bus class.  It is named DefaultBus
    to point out that connection and not because it abstracts a "default"
    bus object.
 */
public class DefaultBus {

    private String routeName;
    private int passengers;
    private int gallonsOfGas;
    private boolean isDoorOpen;


    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getGallonsOfGas() {
        return gallonsOfGas;
    }

    public void setGallonsOfGas(int gallonsOfGas) {
        this.gallonsOfGas = gallonsOfGas;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public void setDoorOpen(boolean doorOpen) {
        isDoorOpen = doorOpen;
    }
}
