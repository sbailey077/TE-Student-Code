package com.techelevator.inventory;

public interface Shippable {

    double getShippingFee();
    int getWeight();
    boolean isPerishable();
}
