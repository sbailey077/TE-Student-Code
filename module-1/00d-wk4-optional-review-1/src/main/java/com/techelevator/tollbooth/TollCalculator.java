package com.techelevator.tollbooth;

import java.util.ArrayList;
import java.util.List;

public class TollCalculator {

    public static void main(String[] args) {

        List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();

        listOfVehicles.add( new Car(false));
        listOfVehicles.add(new Car(true));
        listOfVehicles.add(new Tank());
        listOfVehicles.add(new Truck(4));
        listOfVehicles.add(new Truck(6));
        listOfVehicles.add(new Truck(8));



        System.out.println("Vehicle            Distance Traveled      Toll $");
        System.out.println("------------------------------------------------");

        int totalDistance = 0;
        for (Vehicle vehicle: listOfVehicles) {
            int distance = 100; // random number
            System.out.printf("%-10s            %-10s      $%6.2f%n", vehicle.toString(), distance, vehicle.calculateToll(distance));
            totalDistance += distance;
        }

        System.out.println("Total Distance: " + totalDistance);

    }
}
