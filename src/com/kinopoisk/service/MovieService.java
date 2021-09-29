package com.kinopoisk.service;

import com.kinopoisk.model.Movie;
import com.kinopoisk.model.MovieRequest;
import com.kinopoisk.repository.MoviesLibrary;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private final MoviesLibrary moviesLibrary;

    public MovieService(MoviesLibrary moviesLibrary) {
        this.moviesLibrary = moviesLibrary;
    }

    public List<Movie> searchMovie(MovieRequest movieRequest) {
        List<Movie> listResult = new ArrayList<>();
        for (Movie movie : moviesLibrary.getMovie()) {
            if (movie.getMovieTitle().equalsIgnoreCase(movieRequest.getName())) {
                listResult.add(movie);
            }
        }
        return listResult;
    }
}
