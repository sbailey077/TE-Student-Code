package com.techelevator.inventory;

import java.util.Objects;

public class Pet extends Item implements Shippable {

    private String petName;
    private boolean isAquatic = false;
    private int weight;


    public Pet(String sku, String name, String petName, int weight) {
        super(sku, name);
        this.petName = petName;
        this.weight = weight;
    }

    public Pet(String sku, String name, int weight) {
        super(sku, name);
        this.weight = weight;
    }

    public Pet(double price, String name, String description, String sku, boolean isPerishable, String petName, int weight) {
        super(price, name, description, sku, isPerishable);
        this.petName = petName;
        this.weight = weight;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public boolean hasName() {
        return (petName != null && petName.length() > 0);
    }

    @Override
    public String getDescription() {
        if (hasName()) {
            return getPetName() + " is a " + determineSize() + " " + getName();
        }
        return super.getDescription();

    }

    private String determineSize() {
        if (weight > 50) {
           return "large";
        } else if (weight > 20) {
            return "medium";
        } else {
            return "small";
        }
    }

    public double getShippingFee() {
        double shippingFee = 0;
        switch (determineSize()) {
            case "small":
                shippingFee = 10;
                break;
            case "medium":
                shippingFee = 20;
                break;
            case "large":
                shippingFee = 50;
                break;
            default:
                break;
        }
        if (isAquatic) {
            shippingFee *= 2;
        }
        return shippingFee;
    }

    @Override
    public double getTotalPrice() {
        return getPrice() + getShippingFee();
    }

    public boolean isAquatic() {
        return isAquatic;
    }

    public void setAquatic(boolean isAquatic) {
        this.isAquatic = isAquatic;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pet pet = (Pet) o;
        return isAquatic == pet.isAquatic && weight == pet.weight && Objects.equals(petName, pet.petName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), petName, isAquatic, weight);
    }

    @Override
    public String getTypeCode() {
        return "P";
    }
}
