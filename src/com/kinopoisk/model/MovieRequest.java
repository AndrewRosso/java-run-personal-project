package com.kinopoisk.model;

public class MovieRequest {
    private final String name;

    public MovieRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MovieRequest{" +
                "name=" + name + '\'' +
                '}';
    }
}
