package com.capgemini.training.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomerNotFoundException extends RuntimeException {
}
