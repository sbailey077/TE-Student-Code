package com.techelevator;

import com.techelevator.vehicle.Bus;

public class BusApp {

    public static void main(String[] args) {

        Bus busOne = new Bus();
        Bus busTwo = new Bus("3rd Street");

        busOne.setRouteName("5th Ave");
        System.out.println(busOne.getRouteName());

        System.out.println( busTwo.getRouteName() );

        System.out.println("Is the door on the bus open: " + busOne.isDoorOpen());

        System.out.println("Passenger tries to board: " + busOne.board());

        busOne.openDoor();
        System.out.println("Is the door on the bus open: " + busOne.isDoorOpen());


        System.out.println("Passenger tries to board: " + busOne.board());
        System.out.println("Remaining Seats: " + busOne.getRemainingSeats());

        busOne.board(10);
        System.out.println("Remaining Seats: " + busOne.getRemainingSeats());


    }
}
