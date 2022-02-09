package com.techelevator.inventory;

public class Food extends Item {

    public Food(String sku, String name) {
        super(sku, name);
    }

    @Override
    public double getTotalPrice() {
        return getPrice();
    }
}
