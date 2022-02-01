package com.techelevator.farm;

public class Tractor implements Singable{

    private String name;
    private String sound;

    public Tractor(){
        name = "Tractor";
        sound = "Vroom!";
    }

    @Override
    public String getSound(){
        return sound;
    }

    @Override
    public String getName(){
        return name;
    }
}
