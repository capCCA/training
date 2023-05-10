package com.capgemini.training.errors;

public class CustomerBadRequestException extends RuntimeException {
    public CustomerBadRequestException(String message) {
        super(message);
    }
}
