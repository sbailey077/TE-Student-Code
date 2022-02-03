package com.techelevator.farm;

/*
    The final keyword prevents this class from
    being used as a superclass.
 */
public final class Cat extends FarmAnimal {

    public Cat() {
        super("Cat", "Meow");
    }

    /*
    getSound() cannot be Overridden because
    it has been declared final
     */
//    @Override
//    public String getSound() {
//        return "MEOW!!!!!";
//    }

    @Override
    public void eat() {
        System.out.println("The Cat eats");
    }
}
