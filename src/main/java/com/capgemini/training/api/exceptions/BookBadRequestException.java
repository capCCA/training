package com.capgemini.training.api.exceptions;

public class BookBadRequestException extends RuntimeException {
    public BookBadRequestException(String message) {
        super(message);
    }
}
