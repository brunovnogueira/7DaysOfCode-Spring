package com.br.alura.daysofcode;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {
    record MovieEntity(String title,String image,String year,String imDbRating){}
    record MovieList(List<MovieEntity> items){}
    public MovieList getTop250Movies(RestTemplate restTemplate, String apiKey) {
        ResponseEntity<MovieList> response = restTemplate.getForEntity("https://imdb-api.com/en/API/Top250Movies/" + apiKey, MovieList.class);

        return response.getBody();
    }
}
