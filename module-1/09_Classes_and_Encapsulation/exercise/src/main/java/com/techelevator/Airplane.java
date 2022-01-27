package com.techelevator;

public class Airplane {
    /*
    Member Variables

    planeNumber - String - six-character plane number
    totalFirstClassSeats - int - total number of first class seats on the plane
    bookedFirstClassSeats - int - number of first class seats already booked
    availableFirstClassSeats (derived) - int - number of first class seats available
    totalCoachSeats - int - total number of coach seats on the plane
    bookedCoachSeats - int - number of coach seats already booked
    availableCoachSeats (derived) - int - number of coach seats available
     */

    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    //Getters

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }


    // Constructor

    public Airplane (String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }


    public int getAvailableFirstClassSeats () {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getAvailableCoachSeats () {
        return totalCoachSeats - bookedCoachSeats;
    }


        //Methods

    public boolean reserveSeats (boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass && getAvailableFirstClassSeats() >= totalNumberOfSeats) {
            bookedFirstClassSeats += totalNumberOfSeats;
            return true;
        } else if (!forFirstClass && getAvailableCoachSeats() >= totalNumberOfSeats) {
            bookedCoachSeats += totalNumberOfSeats;
            return true;
        } else {
            return false;
        }
    }






}
