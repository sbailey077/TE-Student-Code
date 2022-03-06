package com.techelevator;

import com.techelevator.model.Item;
import com.techelevator.services.ConsoleService;
import com.techelevator.services.InventoryService;

import java.util.List;

public class App {

    private InventoryService inventoryService = new InventoryService();
    private ConsoleService consoleService = new ConsoleService();

    public void run() {

        List<Item> items = inventoryService.getInventory();
        consoleService.printItems(items);

        Item item = consoleService.askUserForItemDetails();
        inventoryService.addItemToInventory(item);

    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
