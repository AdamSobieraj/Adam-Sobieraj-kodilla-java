package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MoviePrinter {

    public static void main(String[] args) {

        MovieStore  movieStore = new MovieStore();

        String moviesToDisplay = movieStore.getMovies().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.joining("  _!_  "));

        System.out.println("The print");
        System.out.println(moviesToDisplay);

    }

}
