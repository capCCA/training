package com.capgemini.training.api.exceptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public void illegalArgumentExceptionHandler(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public void constraintViolationExceptionHandler(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value());
  }

  @ExceptionHandler({CustomerNotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleCustomerNotFound(
      CustomerNotFoundException ex, WebRequest request) {
    CustomError error =
        CustomError.builder()
            .status(HttpStatus.NOT_FOUND)
            .error(HttpStatus.NOT_FOUND.value())
            .messages(List.of("The id provided does not exist"))
            .build();

    return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
  }

  @ExceptionHandler({CustomerBadRequestException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Object> handleCustomerBadRequest(
      CustomerBadRequestException ex, WebRequest request) {
    CustomError error =
        CustomError.builder()
            .status(HttpStatus.BAD_REQUEST)
            .error(HttpStatus.BAD_REQUEST.value())
            .messages(List.of(ex.getMessage()))
            .build();
    return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    List<String> messages = new ArrayList<String>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      messages.add(error.getField() + ": " + error.getDefaultMessage());
    }

    CustomError error =
        CustomError.builder().status(status).error(status.value()).messages(messages).build();
    return new ResponseEntity<>(error, headers, status);
  }
}

// Note:
//
// one simpler example:
// https://salithachathuranga94.medium.com/validation-and-exception-handling-in-spring-boot-51597b580ffd
//
