package com.capgemini.training.errors;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

public class ErrorHandler {
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
                        .messages(List.of("The customer id does not exist in the database"))
                        .build();

        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }

    @ExceptionHandler({BeneficiaryNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleBeneficiaryNotFound(
            BeneficiaryNotFoundException ex, WebRequest request) {
        CustomError error =
                CustomError.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .error(HttpStatus.NOT_FOUND.value())
                        .messages(List.of("The beneficiary id does not exist in the database"))
                        .build();

        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }

    @ExceptionHandler({PaymentNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePaymentNotFound(
            PaymentNotFoundException ex, WebRequest request) {
        CustomError error =
                CustomError.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .error(HttpStatus.NOT_FOUND.value())
                        .messages(List.of("The payment id does not exist in the database"))
                        .build();

        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }

    @ExceptionHandler({PaymentBadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handlePaymentBadRequest(
            PaymentBadRequestException ex, WebRequest request) {
        CustomError error =
                CustomError.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .error(HttpStatus.BAD_REQUEST.value())
                        .messages(List.of(ex.getMessage()))
                        .build();

        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }
}
