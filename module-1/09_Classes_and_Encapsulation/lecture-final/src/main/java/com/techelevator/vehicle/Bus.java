package com.techelevator.vehicle;

public class Bus {

    private final static int TOTAL_SEATS = 40;
    /*
        Member variables
        Track the state of the object
        Should ALWAYS be private
     */
    private String routeName;
    private int passengers;
    private int gallonsOfGas = 50;
    private boolean isDoorOpen = false;

    /*
        CONSTRUCTORS
     */
    /*
        The default constructor
        Is implicit if no other constructors are present
        Must be explicitly added if any other constructors are present and it is desired
     */
    public Bus() {

    }

    /*
        Constructor overload - gives options on how to instantiate the class
     */
    public Bus(String routeName) {
        this.routeName = cleanRouteName(routeName);
    }

    public Bus(String routeName, int startingGas) {
        this.routeName = cleanRouteName(routeName);
        this.gallonsOfGas = startingGas;
    }

    public Bus(int startingGas) {
        this.gallonsOfGas = startingGas;
    }

    /*
        GETTERS AND SETTERS
     */
    public String getRouteName() {
        return this.routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = cleanRouteName(routeName);
    }

    public int getGallonsOfGas() {
        return this.gallonsOfGas;
    }

    public boolean isDoorOpen() {
        return this.isDoorOpen;
    }

    /*
        ENCAPSULATED (ABSTRACT) SETTERS
     */
    public void addGas(int gallons) {
        this.gallonsOfGas += gallons;
    }

    public void openDoor() {
        this.isDoorOpen = true;
    }

    public void closeDoor() {
        this.isDoorOpen = false;
    }

    /*
        Derived Property
     */
    public int getRemainingSeats() {
        return TOTAL_SEATS - this.passengers;
    }

    /*
        Methods
     */
    public boolean board() {
        if (getRemainingSeats() >= 1 && this.isDoorOpen) {
            this.passengers += 1;
            return true;
        }
        return false;
    }

    public boolean board(int boardingPassengers) {
        if (getRemainingSeats() >= boardingPassengers && this.isDoorOpen) {
            this.passengers += boardingPassengers;
            return true;
        }
        return false;
    }

    private String cleanRouteName(String routeName) {
        String name = routeName.replaceAll(" ", "-");
        return name.toUpperCase();
    }

}
