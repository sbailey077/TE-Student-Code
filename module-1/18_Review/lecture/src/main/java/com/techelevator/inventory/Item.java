package com.techelevator.inventory;

public abstract class Item {

    private double price;
    private String name;
    private String description;
    private String sku;
    private boolean isPerishable;

    public Item(String sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public abstract double getTotalPrice();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }


    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }
}
