package com.techelevator.inventory.dao;

import com.techelevator.inventory.Item;

import java.util.Map;

public interface InventoryDao {

    Map<String, Item> getAllItems();
    Long add(Item item);
}
