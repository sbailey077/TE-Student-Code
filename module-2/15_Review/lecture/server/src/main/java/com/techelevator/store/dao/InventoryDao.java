package com.techelevator.store.dao;

import com.techelevator.store.model.Item;

import java.util.List;

public interface InventoryDao {

    List<Item> getAllItems();
    Item add(Item item);
}
