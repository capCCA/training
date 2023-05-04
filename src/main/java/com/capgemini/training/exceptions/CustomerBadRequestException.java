package com.capgemini.training.exceptions;

public class CustomerBadRequestException extends RuntimeException {
  public CustomerBadRequestException(String message) {
    super(message);
  }
}
