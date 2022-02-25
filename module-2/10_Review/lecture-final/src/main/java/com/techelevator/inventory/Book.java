package com.techelevator.inventory;

public class Book extends Item {

    private static final double FLAT_BOOK_SHIPPING_FEE = 2;

    public Book(String sku, String name) {
        super(sku, name);
    }

    public Book(double price, String name, String description, String sku, boolean isPerishable) {
        super(price, name, description, sku, isPerishable);
    }
    @Override
    public double getTotalPrice() {
        return getPrice() + FLAT_BOOK_SHIPPING_FEE;
    }

    @Override
    public String getTypeCode() {
        return "B";
    }
}
