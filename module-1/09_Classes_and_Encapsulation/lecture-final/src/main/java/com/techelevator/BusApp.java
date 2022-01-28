package com.techelevator;

import com.techelevator.vehicle.Bus;
import com.techelevator.vehicle.DefaultBus;

import java.util.Scanner;

public class BusApp {

    public static void main(String[] args) {

        /*
            Working with the DefaultBus class, which only
            contains the minimum needed to be a viable class
         */
        DefaultBus defaultBus = new DefaultBus();
        defaultBus.setRouteName("2nd Ave");
        defaultBus.setGallonsOfGas(50);
        defaultBus.setDoorOpen(true);



        /*
            Working with the Bus class with all the parts
         */
        Bus busOne = new Bus();
        Bus busTwo = new Bus("3rd Street");
        Bus busThree = new Bus("4th Street", 10);
        Bus busFour = new Bus("", 20);

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
