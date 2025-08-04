package io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions;

public class ObjectNotFoundException extends RuntimeException {
  public ObjectNotFoundException(String message) {
    super(message);
  }
}
