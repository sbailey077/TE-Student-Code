package com.techelevator.services;


import com.techelevator.model.Item;

import java.util.List;
import java.util.Scanner;

public class ConsoleService {

  private static final Scanner in = new Scanner(System.in);;

  public void printItems(List<Item> items) {

      for (Item item : items) {
        System.out.println(item.getName());
      }
  }

  public Item askUserForItemDetails() {
    Item item = new Item();

    System.out.println("Type (F, C, B): ");
    item.setTypeCode( in.nextLine() );

    System.out.println("Sku: ");
    item.setSku( in.nextLine() );

    System.out.println("Name: ");
    item.setName( in.nextLine() );

    System.out.println("Price: ");
    item.setPrice( in.nextDouble() );
    in.nextLine();

    return item;
  }

}
