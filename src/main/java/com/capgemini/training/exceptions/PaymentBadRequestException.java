package com.capgemini.training.exceptions;

public class PaymentBadRequestException extends RuntimeException {
    public PaymentBadRequestException(String message) {
        super(message);
    }
}