package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    public Map<String, Item> getInventory() {
        Item cake = new Item("001");
        cake.setName("Cake");
        cake.setDescription("A chocolate cake");
        cake.setPerishable(true);
        cake.setPrice(10);

        Item flipflops = new Item("002");
        flipflops.setName("Flip Flop Sandals");
        flipflops.setDescription("Protect your feet, but only the bottoms");
        flipflops.setPerishable(false);
        flipflops.setPrice(7);

        Item cat = new Item("cat01");
        cat.setName("Cat");
        cat.setDescription("Covered in fur");
        cat.setPerishable(true);
        cat.setPrice(100);

        Item frog = new Item("f22");
        frog.setName("Frog");
        frog.setDescription("Greenish and not a toad");
        frog.setPerishable(true);
        frog.setPrice(5.25);


        Map<String, Item> inventory = new HashMap<String, Item>();

        inventory.put(cake.getSku(), cake);
        inventory.put(flipflops.getSku(), flipflops);
        inventory.put(cat.getSku(), cat);
        inventory.put(frog.getSku(), frog);

        return inventory;
    }
}
