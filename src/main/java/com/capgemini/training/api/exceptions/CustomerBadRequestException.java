package com.capgemini.training.api.exceptions;

public class CustomerBadRequestException extends RuntimeException {
    public CustomerBadRequestException(String message) {
        super(message);
    }
}
