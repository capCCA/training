package com.capgemini.training.controller;


import javax.validation.Valid;

import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.service.SavePaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

/*
*
* Ejemplo de Entrada en Postman:
*
    {
        "paymentType": "BIZUM",
        "amount": 2005,
        "userDto": {
            "customerId": "custom100"
        },
        "beneficiaryDto": {
            "beneficiaryId": "1"
        }
    }

 */

@RequestMapping(value = "/payment")
@RestController
@RequiredArgsConstructor
public class SavePaymentController {

    private final SavePaymentService savePaymentService;


    @PostMapping
    public ResponseEntity<PaymentDto> savePayment(@Valid @RequestBody(required = true) PaymentDto paymentDto) {
        savePaymentService.savePayment(paymentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentDto);

    }

}
