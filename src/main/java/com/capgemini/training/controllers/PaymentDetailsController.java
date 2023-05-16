package com.capgemini.training.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/payments")
public class PaymentDetailsController {

    @PostMapping("/")
    public ResponseEntity createNewPayment(@Valid @RequestBody @NotNull(message="El objeto payment enviado es incorrecto") PaymentDetail) {

        return ResponseEntity.ok().body(newCustomerDetailsService.saveUser(customerDetails));

    }

}
