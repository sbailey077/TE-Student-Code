package com.techelevator;

public abstract class Wall {

    private String name;
    private String color;
    private int area;

    public Wall(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public abstract int getArea();
}
