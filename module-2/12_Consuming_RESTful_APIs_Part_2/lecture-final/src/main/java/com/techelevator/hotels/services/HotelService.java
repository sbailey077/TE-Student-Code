package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        } catch (RestClientResponseException e) {
            // Handle common HTTP errors like 4xx and 5xx
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // handle connection errors
            BasicLogger.log(e.getMessage());
            throw e;
        }
        return hotels;
    }

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
        /*
            1. Create the Header for ContentType
            2. Add Reservation to the message body
            3. Send the request with the message body and header as a POST to the API
         */
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
                                                                    // reservation object, headers
        HttpEntity<Reservation> entity = new HttpEntity<Reservation>(newReservation, headers);

        String url = API_BASE_URL + "hotels/" + newReservation.getHotelId() + "/reservations";
        Reservation returnedReservation = null;

        try {
            returnedReservation = restTemplate.postForObject(url, entity, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return returnedReservation;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        /*
            1. Create a header for content type application/json
            2. Create a message with the updatedReservation object as the body
            3. Send it as a PUT request
         */
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Reservation> entity = new HttpEntity<Reservation>(updatedReservation, headers);

        boolean wasSuccessful = false;

        try {
            String url = API_BASE_URL + "reservations/" + updatedReservation.getId();
            restTemplate.put(url, entity);
            wasSuccessful = true;
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }

        return wasSuccessful;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {
        String url = API_BASE_URL + "reservations/" + id;
        boolean wasSuccessful = false;

        try {
            restTemplate.delete(url);
            wasSuccessful = true;
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return wasSuccessful;
    }


    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}