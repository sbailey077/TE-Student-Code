package com.techelevator.vehicle;

public class Bus {

    /*

        Member variables
        Track the state of the object
        Should ALWAYS BE PRIVATE

     */
    private String routeName;
    private int passengerCount;
    private int gallonsofGas = 50;
    private boolean isDoorOpen = false;

    public String getRouteName() {
        String name = routeName.replaceAll(" ", "-");
        this.routeName = name.toUpperCase();
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getGallonsofGas() {
        return this.gallonsofGas;
    }

    public boolean isDoorOpen() {
        return this.isDoorOpen;
    }
}
