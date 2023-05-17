package com.capgemini.training.exceptions;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(String msg ){
        super(msg);
    }
}
