package com.techelevator;

import com.techelevator.inventory.Item;

import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static final Scanner userInput = new Scanner(System.in);

    public String getInputFromUser(String question) {
        System.out.println(question);
        return userInput.nextLine();
    }

    public void displayError(String message) {
        System.out.println("***** ERROR *****");
        System.out.println(message);
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome to Java Blue Mart");
        System.out.println();
    }

    public void showItemsForSale(Map<String, Item> inventory) {
        System.out.println("Items for Sale");

        for ( Map.Entry<String, Item> mapEntry : inventory.entrySet()) {

            System.out.print( mapEntry.getValue().getSku() );
            System.out.print( " : " + mapEntry.getValue().getName() );
            System.out.print( " ( " + mapEntry.getValue().getDescription() + " ) ");
            System.out.println( " $" + mapEntry.getValue().getTotalPrice() );

        }
    }

    public String getSelectedSkuFromUser() {
        System.out.println();
        System.out.print("Item to purchase >>>");
        return userInput.nextLine();
    }

    public void showUserSelectedItem(Item selectedItem) {
        System.out.println("You selected to purchase a: ");
        System.out.println(selectedItem.getName());
        System.out.println("Description: " + selectedItem.getDescription());
        System.out.println("Total Price: " + selectedItem.getTotalPrice());
    }
}
