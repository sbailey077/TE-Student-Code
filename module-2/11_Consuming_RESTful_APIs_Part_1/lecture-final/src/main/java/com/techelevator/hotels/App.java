package com.techelevator.hotels;

import com.techelevator.hotels.model.Country;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    private static final int MENU_EXIT = 0;
    private static final int MENU_LIST_HOTELS = 1;
    private static final int MENU_LIST_REVIEWS = 2;
    private static final int MENU_SHOW_DETAILS_FOR_HOTEL_1 = 3;
    private static final int MENU_SHOW_REVIEWS_FOR_HOTEL_1 = 4;
    private static final int MENU_LIST_HOTELS_WITH_3_STAR_RATING = 5;
    private static final int MENU_PUBLIC_API_QUERY = 6;


    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == MENU_LIST_HOTELS) {
                System.out.println("Not implemented");
            } else if (menuSelection == MENU_LIST_REVIEWS) {
                System.out.println("Not implemented");
            } else if (menuSelection == MENU_SHOW_DETAILS_FOR_HOTEL_1) {
                System.out.println("Not implemented");
            } else if (menuSelection == MENU_SHOW_REVIEWS_FOR_HOTEL_1) {
                System.out.println("Not implemented");
            } else if (menuSelection == MENU_LIST_HOTELS_WITH_3_STAR_RATING) {
                System.out.println("Not implemented");
            } else if (menuSelection == MENU_PUBLIC_API_QUERY) {
               System.out.println("Not implemented - Create a custom Web API query here");
            } else if (menuSelection == MENU_EXIT) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
