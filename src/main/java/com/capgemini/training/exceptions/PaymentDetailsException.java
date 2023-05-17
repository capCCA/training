package com.capgemini.training.exceptions;

public class PaymentDetailsException extends RuntimeException{
    public PaymentDetailsException(String msg ){
        super(msg);
    }
}
