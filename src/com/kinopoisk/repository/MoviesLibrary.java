package com.kinopoisk.repository;

import com.kinopoisk.model.Movie;

import java.util.Arrays;
import java.util.List;

public class MoviesLibrary {
    private final List<Movie> movies = Arrays.asList(
            new Movie("Batman Begins", 2005, "Christopher Nolan"),
            new Movie("X-Men: First Class", 2011, "Matthew Vaughn"),
            new Movie("The Avengers", 2012, "Joss Whedon"),
            new Movie("Interstellar", 2014, "Christopher Nolan"),
            new Movie("The Gentlemen", 2019, "Guy Ritchie"),
            new Movie("Terminator 2: Judgment Day", 1991, "James Cameron"));

    public List<Movie> getMovie() {
        return movies;
    }
}
