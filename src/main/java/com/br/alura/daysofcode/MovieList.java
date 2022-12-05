package com.br.alura.daysofcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieList {
    //the response json has one key ("items") that as value has a list of objects
    //items is the attribute and its type is a list, which elements belong to MovieEntity class
    private List<MovieEntity> items;
}
