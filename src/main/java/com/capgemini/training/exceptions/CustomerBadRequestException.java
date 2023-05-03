package com.capgemini.training.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomerBadRequestException extends RuntimeException {
  public CustomerBadRequestException(String message) {
    super(message);
  }
}
