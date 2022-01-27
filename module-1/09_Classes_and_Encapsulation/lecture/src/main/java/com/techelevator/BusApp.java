package com.techelevator;

import com.techelevator.vehicle.Bus;

public class BusApp {

    public static void main(String[] args) {


        Bus busOne = new Bus();
        Bus busTwo = new Bus();

        busOne.setRouteName("5th Avenue");
        System.out.println(busOne.getRouteName());

        busTwo.setRouteName("3rd Avenue");
        System.out.println(busTwo.getRouteName());



    }
}
