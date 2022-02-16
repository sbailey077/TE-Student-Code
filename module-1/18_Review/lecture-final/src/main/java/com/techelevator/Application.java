package com.techelevator;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.Item;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Application {

    private Menu menu;

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        menu = new Menu();

        Inventory inventoryBuilder = null;
        boolean hasFileLocation = false;
        while(!hasFileLocation) {
            String inventoryPath = menu.getInputFromUser("Path to inventory file: ");
            try {
                inventoryBuilder = new Inventory(inventoryPath);
                hasFileLocation = true;
            } catch (FileNotFoundException e) {
                menu.displayError("File not found.");
            }
        }

        menu.showWelcomeMessage();


        Map<String, Item> inventory = inventoryBuilder.getInventory();

        menu.showItemsForSale(inventory);

        String skuToPurchase = menu.getSelectedSkuFromUser();
        Item selectedItem = inventory.get(skuToPurchase);

        menu.showUserSelectedItem(selectedItem);

    }
    
}
