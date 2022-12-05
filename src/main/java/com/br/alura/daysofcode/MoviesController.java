package com.br.alura.daysofcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@RestController
public class MoviesController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    MovieService movieService;
    @Value("${apiKey}")
    private String apiKey;

    @RequestMapping("/top250movies")
    public MovieService.MovieList getTop250Movies(){
        return movieService.getTop250Movies(restTemplate,apiKey);
    }

    @RequestMapping("/generateHTML")
    public String generateHTML() throws FileNotFoundException {
        MovieService.MovieList response = movieService.getTop250Movies(restTemplate,apiKey);

        PrintWriter writer = new PrintWriter("src/main/resources/content.html");

        new HTMLGenerator(writer).generate(response);

        writer.close();

        return "HTML GERADO!";
    }
}
