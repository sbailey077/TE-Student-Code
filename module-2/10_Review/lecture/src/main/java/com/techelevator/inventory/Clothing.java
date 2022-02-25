package com.techelevator.inventory;

public class Clothing extends Item implements Taxable {

    private double taxRate = 0.0075;

    public Clothing(String sku, String name) {
        super(sku, name);
    }

    @Override
    public double getTotalPrice() {
        return getPrice() + (getPrice() * getTaxRate());
    }

    @Override
    public double getTaxRate() {
        return this.taxRate;
    }

    @Override
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
