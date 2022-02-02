package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable{

    private String name;
    private BigDecimal price;

    public Egg(){
        name = "Egg";
        price = new BigDecimal("0.25");
    }

    public static double calculateTotalCost(int count, double price) {
        int dozens = count / 12;
        double total = (price * count) - ( dozens * .25);
        return total;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
