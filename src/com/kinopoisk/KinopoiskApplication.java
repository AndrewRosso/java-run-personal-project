package com.kinopoisk;

import com.kinopoisk.handlers.MovieRequestHandler;
import com.kinopoisk.repository.MoviesLibrary;
import com.kinopoisk.service.MovieService;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class KinopoiskApplication {
    public static void main(String[] args) throws IOException {
        MoviesLibrary moviesLibrary = new MoviesLibrary();
        MovieService movieService = new MovieService(moviesLibrary);
        MovieRequestHandler movieRequestHandler = new MovieRequestHandler(movieService);

        InetSocketAddress addr = new InetSocketAddress(8080);

        HttpServer server = HttpServer.create(addr, 0);
        server.createContext("/movies/search", movieRequestHandler);
        server.start();
    }
}