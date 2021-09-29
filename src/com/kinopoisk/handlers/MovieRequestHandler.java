package com.kinopoisk.handlers;

import com.kinopoisk.model.Movie;
import com.kinopoisk.model.MovieRequest;
import com.kinopoisk.service.MovieService;
import com.kinopoisk.utils.Utils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class MovieRequestHandler implements HttpHandler {
    private final MovieService movieService;

    public MovieRequestHandler(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        MovieRequest movieRequest = getMovieRequest(exchange);
        List<Movie> listResult = movieService.searchMovie(movieRequest);
        handleResponce(exchange, listResult.toString());
    }


    private void handleResponce(HttpExchange httpExchange, String responseBody) throws IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        httpExchange.sendResponseHeaders(200, responseBody.length());
        outputStream.write(responseBody.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    private MovieRequest getMovieRequest(HttpExchange exchange) {
        String query = exchange.getRequestURI().getRawQuery();
        Map<String, String> parameters = Utils.queryToMap(query);

        MovieRequest movieRequest = new MovieRequest();
        movieRequest.setName(parameters.get(RequestParameters.NAME));
        return movieRequest;

    }

    private static class RequestParameters {
        private static final String NAME = "name";
    }
}
