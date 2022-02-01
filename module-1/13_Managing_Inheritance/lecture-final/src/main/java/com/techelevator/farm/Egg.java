package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable{

    private String name;
    private BigDecimal price;

    public Egg(){
        name = "Egg";
        price = new BigDecimal("0.25");
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
