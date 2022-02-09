package com.techelevator;

public class MovieRental {

    private String title = "";
    private String format = "";
    private boolean isPremiumMovie = false;
    private double rentalPrice = 0.0;
    private int daysLate = 0;

    public MovieRental (String title, String format, Boolean isPremiumMovie) {
        this.title = title;
        this.format = format;
        this.isPremiumMovie = isPremiumMovie;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isPremiumMovie() {
        return isPremiumMovie;
    }

    public void setPremiumMovie(boolean premiumMovie) {
        isPremiumMovie = premiumMovie;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }


    public double determineRentalPrice(String format, boolean isPremiumMovie){
        if (format.equalsIgnoreCase("VHS")) {
            rentalPrice = 0.99;
        } else if (format.equalsIgnoreCase("DVD")) {
            rentalPrice = 1.99;
        } else if (format.equalsIgnoreCase("BluRay")) {
            rentalPrice = 2.99;
        }
        if (isPremiumMovie) {
            rentalPrice += 1.00;
        } return rentalPrice;
    }

    public double determineLateFee(int daysLate) {
        if (daysLate == 0) {
            return 0.00;
        } else if (daysLate == 1) {
            return 1.99;
        } else if (daysLate == 2) {
            return 3.99;
        } else if (daysLate >= 3) {
            return 19.99;
        } else {
            return 0.00;
        }
    }

    @Override
    public String toString() {
        return "MOVIE - " + title + " - " + format + " - " + rentalPrice;
    }

}




