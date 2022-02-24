package com.techelevator.inventory;

import com.techelevator.inventory.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    private String inventoryFilePath;
    private Map<String, Item> inventory = new HashMap<String, Item>();

    public Inventory(String inventoryFilePath) throws FileNotFoundException {
        this.inventoryFilePath = inventoryFilePath;
        loadInventoryFromFile();
    }

    public Map<String, Item> getInventory() {
        return this.inventory;
    }

    private void loadInventoryFromFile() throws FileNotFoundException {
        File file = new File(inventoryFilePath);
        try (Scanner inventoryScanner = new Scanner(file)) {
            while (inventoryScanner.hasNextLine()) {
                String line = inventoryScanner.nextLine();
                Item newItem = buildItemFromLine(line);
                inventory.put(newItem.getSku(), newItem);
            }
        }
    }

    private Item buildItemFromLine(String line) {
        Item item = null;
        String[] parts = line.split("\\|");

        String sku = parts[0];
        String name = parts[1];
        String description = parts[2];
        String perishable = parts[3];
        String price = parts[4];
        String type = parts[5];

        if (type.equalsIgnoreCase("F")) {
           item = new Food(sku, name);
        } else if (type.equalsIgnoreCase("C")) {
           item = new Clothing(sku, name);
        } else if (type.equalsIgnoreCase("B")) {
            item = new Book(sku, name);
        } else if (type.equalsIgnoreCase("P")) {
            String weight = parts[6];
            String petName = parts[7];
            item = new Pet(sku, name, petName, Integer.parseInt(weight));
        }


        item.setDescription(description);
        item.setPerishable( perishable.equalsIgnoreCase("Y") );
        item.setPrice(Double.parseDouble(price));
        return item;
    }
}
