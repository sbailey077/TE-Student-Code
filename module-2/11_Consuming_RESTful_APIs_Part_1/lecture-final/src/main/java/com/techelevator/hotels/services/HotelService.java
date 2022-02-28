package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Country;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {

        Hotel[] hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);

        return hotels;
    }

    public Review[] listReviews() {
        String url = API_BASE_URL + "reviews";
        Review[] reviews = restTemplate.getForObject(url, Review[].class);
        return reviews;
    }

    public Hotel getHotelById(int id) {
        String url =  API_BASE_URL + "hotels/" + id;
        Hotel hotel = restTemplate.getForObject(url, Hotel.class);
        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        String url = API_BASE_URL + "hotels/" + hotelID + "/reviews";
        return restTemplate.getForObject(url, Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        String url = API_BASE_URL  + "hotels?stars=" + stars;
        return restTemplate.getForObject(url, Hotel[].class);
    }

    public Country getWithCustomQuery(){
        Country country = restTemplate.getForObject("https://api.country.is/198.185.159.144", Country.class);
        return country;
    }

}
