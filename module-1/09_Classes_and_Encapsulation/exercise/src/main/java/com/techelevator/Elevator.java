package com.techelevator;

public class Elevator {

    /*
    Member Variables
     */

    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen;

    //Getters


    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    //Constructor

    public Elevator (int numberOfLevels) {
        this.numberOfFloors = numberOfLevels;
    }

    //Methods

    public void openDoor(){
        doorOpen = true;
    }

    public void closeDoor(){
        doorOpen = false;
    }

    public void goUp (int desiredFloor) {
        if (!doorOpen && (currentFloor < desiredFloor && desiredFloor <= numberOfFloors)) {
            currentFloor = desiredFloor;
        }
    }

    public void goDown (int desiredFloor) {
        if (!doorOpen && (currentFloor > desiredFloor && desiredFloor >= 1)) {
            currentFloor = desiredFloor;
        }
    }
}
