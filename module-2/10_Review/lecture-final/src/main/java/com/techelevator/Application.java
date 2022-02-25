package com.techelevator;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.Item;
import com.techelevator.inventory.dao.FileInventoryDao;
import com.techelevator.inventory.dao.InventoryDao;
import com.techelevator.inventory.dao.JdbcInventoryDao;
import org.apache.commons.dbcp2.BasicDataSource;

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

        String inventorySelection = menu.getInputFromUser("Use Database (Y/N)?: ");
        InventoryDao inventoryReader = null;

        if (inventorySelection.equalsIgnoreCase("N")) {

            boolean hasFileLocation = false;
            while(!hasFileLocation) {
                String inventoryPath = menu.getInputFromUser("Path to inventory file: ");
                try {
                    inventoryReader = new FileInventoryDao(inventoryPath);
                    hasFileLocation = true;
                } catch (FileNotFoundException e) {
                    menu.displayError("File not found.");
                }
            }
        } else {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:postgresql://localhost:5432/JavaBlueMart");
            dataSource.setUsername("postgres");
            dataSource.setPassword("postgres1");

            inventoryReader = new JdbcInventoryDao(dataSource);
        }


        menu.showWelcomeMessage();


        Map<String, Item> inventory = inventoryReader.getAllItems();

        menu.showItemsForSale(inventory);

        String skuToPurchase = menu.getSelectedSkuFromUser();
        Item selectedItem = inventory.get(skuToPurchase);

        menu.showUserSelectedItem(selectedItem);

    }
    
}
