package com.capgemini.training.exceptions;

public class BeneficiaryNotFoundException extends RuntimeException {

    public BeneficiaryNotFoundException(String msg) {
        super(msg);
    }
}