package com.techelevator;

public class Cake {

    private String icingColor;
    private boolean hasSprinkles;


    public Cake(String icingColor, boolean hasSprinkles) {
        this.icingColor = icingColor;
        this.hasSprinkles = hasSprinkles;
    }

    public String getIcingColor() {
        return icingColor;
    }

    public void setIcingColor(String icingColor) {
        this.icingColor = icingColor;
    }

    public boolean isHasSprinkles() {
        return hasSprinkles;
    }

    public void setHasSprinkles(boolean hasSprinkles) {
        this.hasSprinkles = hasSprinkles;
    }

}
