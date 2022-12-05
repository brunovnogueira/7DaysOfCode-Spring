package com.br.alura.daysofcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {
    //elements of the "items" list have the attributes bellow:
    private String title;
    private String image;
    private String year;
    private String imDbRating;
}
