package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable{

    private BigDecimal price;

    public Pig(){
        super("Pig", "oink!");
        price = new BigDecimal("500.00");
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void eat() {
        System.out.println("The Pig eats");
    }
}
