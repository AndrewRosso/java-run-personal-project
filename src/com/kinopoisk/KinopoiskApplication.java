package com.kinopoisk;

import com.kinopoisk.handlers.MovieRequestHandler;
import com.kinopoisk.repository.MoviesLibrary;
import com.kinopoisk.service.MovieService;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class KinopoiskApplication {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        MoviesLibrary moviesLibrary = new MoviesLibrary();
        MovieService movieService = new MovieService(moviesLibrary);
        server.createContext("/movies/search", new MovieRequestHandler(movieService));
        server.start();
    }
}
