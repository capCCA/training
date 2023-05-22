package com.capgemini.training.api.exceptions;

public class PaymentBadRequestException extends RuntimeException {
    public PaymentBadRequestException(String message) {
        super(message);
    }
}
