package com.api.techchristian.ms.ticket.client;

import com.api.techchristian.ms.ticket.dto.MovieResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Component
public class MovieClient {
    private final RestClient restClient;

    public MovieClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public MovieResponse getMovie(UUID movieId){
        return restClient.get()
                .uri("http://localhost:8081/v1/api/movies/{id}", movieId)
                .retrieve()
                .body(MovieResponse.class);
    }
}
