package com.getcollector.faker.service;

public class LocaleDoesNotExistException extends RuntimeException {
  public LocaleDoesNotExistException(String message) {
      super(message);
    }
}
