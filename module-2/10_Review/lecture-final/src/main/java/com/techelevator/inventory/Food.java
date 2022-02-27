package com.techelevator.inventory;

public class Food extends Item {

    public Food(String sku, String name) {
        super(sku, name);
    }

    public Food(double price, String name, String description, String sku, boolean isPerishable) {
        super(price, name, description, sku, isPerishable);
    }

    @Override
    public double getTotalPrice() {
        return getPrice();
    }

    @Override
    public String getTypeCode() {
        return "F";
    }
}
