package com.techelevator.chucknorris;

import org.springframework.web.client.RestTemplate;

public class JokeApp {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.icndb.com/jokes/random?exclue=explicit&limitTo=nerdy";
        ChuckNorrisResponse response = restTemplate.getForObject(url, ChuckNorrisResponse.class);
        System.out.println(response.getValue().getJoke());

    }
}
