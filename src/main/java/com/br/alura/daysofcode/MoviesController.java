package com.br.alura.daysofcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MoviesController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${apiKey}")
    private String apiKey;
    record MovieEntity(String title,String image,String year,String imDbRating){}
    record MovieList(List<MovieEntity> items){}
    @RequestMapping("/top250movies")
    public MovieList getTop250Movies(){
        ResponseEntity<MovieList> response = restTemplate.getForEntity("https://imdb-api.com/en/API/Top250Movies/"+apiKey, MovieList.class);

        return response.getBody();
    }
}
