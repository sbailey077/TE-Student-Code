package com.techelevator;

public class Item {

    private double price;
    private String name;
    private String description;
    private String sku;
    private boolean isPerishable;

    public Item(String sku) {
        this.sku = sku;
    }


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
