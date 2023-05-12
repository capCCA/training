package com.capgemini.training.errors.exceptions;

public class PaymentBadRequestException extends RuntimeException {

  public PaymentBadRequestException(String message) {
    super(message);
  }
}
