package com.capgemini.training.controller;

import java.util.List;

import javax.validation.Valid;

import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.service.SavePaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.model.UserDto;

import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/payment")
@RestController
@RequiredArgsConstructor
public class SavePaymentController {

    private final SavePaymentService savePaymentService;

    /**
     * Method to save Users (customers)
     *
     * @return {@link List} de {@link UserDto}
     * @throws Exception
     */

    @PostMapping
    public ResponseEntity<PaymentDto> savePayment(@Valid @RequestBody(required = true) PaymentDto paymentDto) {
        savePaymentService.savePayment(paymentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentDto);

    }

}
