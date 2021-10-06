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

import static com.kinopoisk.utils.Utils.convertAddressLineQueryWhitespace;


public class MovieRequestHandler implements HttpHandler {
    private final MovieService movieService;

    public MovieRequestHandler(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = convertAddressLineQueryWhitespace(exchange.getRequestURI().getRawQuery());
        MovieRequest movieRequest = getMovieRequest(query);
        List<Movie> listResult = movieService.searchMovie(movieRequest);
        handleResponse(exchange, listResult.toString());
    }

    private void handleResponse(HttpExchange httpExchange, String responseBody) throws IOException {
        httpExchange.sendResponseHeaders(200, responseBody.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(responseBody.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    private MovieRequest getMovieRequest(String query) {
        Map<String, String> parameters = Utils.queryToMap(query);

        return new MovieRequest(parameters.get("name"));
    }
}
