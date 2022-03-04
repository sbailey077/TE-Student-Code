package com.techelevator.services;

import com.techelevator.model.Item;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class InventoryService {

    private final static String BASE_API_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Item> getInventory() {
        Item[] items = restTemplate.getForObject(BASE_API_URL + "items", Item[].class);
        return Arrays.asList(items);
    }

    public Item addItemToInventory(Item item) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Item> entity = new HttpEntity<Item>(item);

        Item itemReturnedFromApi = restTemplate.postForObject(BASE_API_URL + "items", entity, Item.class);
        return itemReturnedFromApi;
    }

}
