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
            if (compareRequest(movie, movieRequest)) {
                listResult.add(movie);
            }
        }
        return listResult;
    }

    private boolean compareRequest(Movie movie, MovieRequest movieRequest) {
        return compare(movie.getMovieTitle(), movieRequest.getName());
    }

    private boolean compare(String sourceParam, String requestParam) {
        return requestParam == null || requestParam.isEmpty() || sourceParam.equalsIgnoreCase(requestParam);
    }
}
