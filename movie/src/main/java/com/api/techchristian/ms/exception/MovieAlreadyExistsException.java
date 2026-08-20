package com.api.techchristian.ms.exception;

public class MovieAlreadyExistsException extends RuntimeException {
  public MovieAlreadyExistsException(String message) {
    super(message);
  }
}
