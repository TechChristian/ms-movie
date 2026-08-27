package com.api.techchristian.ms.ticket.client;

import com.api.techchristian.ms.ticket.dto.MovieResponse;
import com.api.techchristian.ms.ticket.dto.UserResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Component
public class UserClient {
    private final RestClient restClient;

    public UserClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public UserResponse getUser(UUID userId){
        return restClient.get()
                .uri("http://localhost:8080/v1/api/users/{id}", userId)
                .retrieve()
                .body(UserResponse.class);
    }
}
