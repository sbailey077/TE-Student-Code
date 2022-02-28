package com.techelevator.hotels;

import com.techelevator.hotels.model.Country;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
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
                Hotel[] hotels = hotelService.listHotels();
                consoleService.printHotels(hotels);
            } else if (menuSelection == MENU_LIST_REVIEWS) {
                Review[] reviews = hotelService.listReviews();
                consoleService.printReviews(reviews);
            } else if (menuSelection == MENU_SHOW_DETAILS_FOR_HOTEL_1) {
                Hotel hotelOne = hotelService.getHotelById(1);
                consoleService.printHotel(hotelOne);
            } else if (menuSelection == MENU_SHOW_REVIEWS_FOR_HOTEL_1) {
                Review[] reviewsForHotelOne = hotelService.getReviewsByHotelId(1);
                consoleService.printReviews(reviewsForHotelOne);
            } else if (menuSelection == MENU_LIST_HOTELS_WITH_3_STAR_RATING) {
                Hotel[] hotelsWith3StarReview = hotelService.getHotelsByStarRating(3);
                consoleService.printHotels(hotelsWith3StarReview);
            } else if (menuSelection == MENU_PUBLIC_API_QUERY) {
                Country country = hotelService.getWithCustomQuery();
                System.out.println(country);
            } else if (menuSelection == MENU_EXIT) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
