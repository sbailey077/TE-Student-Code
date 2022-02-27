package com.techelevator.inventory;

import java.util.Objects;

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

    public Item(double price, String name, String description, String sku, boolean isPerishable) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.isPerishable = isPerishable;
    }

    public abstract double getTotalPrice();
    public abstract String getTypeCode();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && isPerishable == item.isPerishable && Objects.equals(name, item.name)
                && Objects.equals(description, item.description) && Objects.equals(sku, item.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, description, sku, isPerishable);
    }
}
