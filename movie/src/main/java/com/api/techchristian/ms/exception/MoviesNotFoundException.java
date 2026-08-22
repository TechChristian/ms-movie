package com.api.techchristian.ms.exception;

public class MoviesNotFoundException extends RuntimeException {
    public MoviesNotFoundException(String message) {
        super(message);
    }
}
