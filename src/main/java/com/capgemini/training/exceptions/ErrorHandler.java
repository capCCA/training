package com.capgemini.training.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler({CustomerNotFoundException.class})
  public ResponseEntity<Object> handleCustomerNotFound(
      CustomerNotFoundException ex, WebRequest request) {
    CustomError error =
        CustomError.builder()
            .status(HttpStatus.NOT_FOUND)
            .error(HttpStatus.NOT_FOUND.value())
            .message("The id does not exist in the database")
            .build();

    return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
  }

  @ExceptionHandler({CustomerBadRequestException.class})
  public ResponseEntity<Object> handleCustomerBadRequest(
      CustomerBadRequestException ex, WebRequest request) {
    CustomError error =
        CustomError.builder()
            .status(HttpStatus.BAD_REQUEST)
            .error(HttpStatus.BAD_REQUEST.value())
            .message(ex.getMessage())
            .build();
    return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
  }
}
