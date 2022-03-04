package com.techelevator.services;

import com.techelevator.model.Item;
import org.junit.*;

import java.util.List;

public class InventoryServiceTest {

    private InventoryService inventoryService;

    @Before
    public void setup() {
        this.inventoryService = new InventoryService();
    }

    @Test
    public void get_all_inventory() {
        List<Item> items = inventoryService.getInventory();
        Assert.assertNotNull(items);
        Assert.assertTrue(items.size() > 0);
    }
}
