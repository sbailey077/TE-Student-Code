package com.techelevator.inventory.dao;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.Item;

import java.io.FileNotFoundException;
import java.util.Map;

public class FileInventoryDao implements InventoryDao {


    private Map<String, Item> items;

    public FileInventoryDao(String filepath) throws FileNotFoundException {
        Inventory inventory = new Inventory(filepath);
        items = inventory.getInventory();
    }

    @Override
    public Map<String, Item> getAllItems() {
        return items;
    }

    @Override
    public Long add(Item item) {
        throw new UnsupportedOperationException();
    }
}
