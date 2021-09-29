package com.kinopoisk.model;

public final class Movie {
    private final String movieTitle;
    private final int yearOfRelease;
    private final String director;

    public Movie(String movieTitle, int yearOfRelease, String director) {
        this.movieTitle = movieTitle;
        this.yearOfRelease = yearOfRelease;
        this.director = director;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    @Override
    public String toString() {
        return "{"+
                "\"movieTitle\": "+"\""+movieTitle+"\""+","+
                "\"yearOfRelease\": "+yearOfRelease+","+
                "\"director\": "+"\""+director+"\""+
                "}";
    }
}
