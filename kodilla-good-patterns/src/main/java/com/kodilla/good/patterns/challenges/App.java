package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();

        Map<String, List<String>> movies = movieStore.getMovies();

        String moviesTitles = movies.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toSet()).stream()
                .collect(Collectors.joining("!"));

        System.out.println(moviesTitles);
    }
}
