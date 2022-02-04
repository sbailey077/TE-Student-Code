package com.techelevator.inventory;

import com.techelevator.inventory.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    public Map<String, Item> getInventory() {
        Item cake = new Food("001", "Cake");
        cake.setDescription("A chocolate cake");
        cake.setPerishable(true);
        cake.setPrice(10);

        Item flipflops = new Clothing("002", "Flip Flop Sandals");
        flipflops.setDescription("Protect your feet, but only the bottoms");
        flipflops.setPerishable(false);
        flipflops.setPrice(7);

        Item cat = new Pet("cat01", "Cat", "Evil Bob", 10);
        cat.setDescription("Covered in fur");
        cat.setPerishable(true);
        cat.setPrice(100);

        Item frog = new Pet("f22", "Frog", 25);
        frog.setDescription("Greenish and not a toad");
        frog.setPerishable(true);
        frog.setPrice(5.25);


        Map<String, Item> inventory = new HashMap<String, Item>();

        inventory.put(cake.getSku(), cake);
        inventory.put(flipflops.getSku(), flipflops);
        inventory.put(cat.getSku(), cat);
        inventory.put(frog.getSku(), frog);
        inventory.put("B1", new Book("B1", "Head First Java"));

        return inventory;
    }
}
