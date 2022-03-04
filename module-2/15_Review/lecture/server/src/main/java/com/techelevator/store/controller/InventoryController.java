package com.techelevator.store.controller;

import com.techelevator.store.dao.InventoryDao;
import com.techelevator.store.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    private InventoryDao inventoryDao;

    public InventoryController(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @RequestMapping(path="/items", method= RequestMethod.GET)
    public List<Item> listInventory() {
        return inventoryDao.getAllItems();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/items", method=RequestMethod.POST)
    public Item add(@RequestBody Item itemToAdd) {
        return inventoryDao.add(itemToAdd);
    }

}
