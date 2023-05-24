package com.capgemini.training.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.api.model.PaymentDetails;
import com.capgemini.training.api.service.NewPaymentDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "PaymentEntity", description = "API of PaymentGetController")
@RestController
@RequestMapping(path = "/payments")
@RequiredArgsConstructor
@Transactional
public class NewPaymentDetailsController {

    public final NewPaymentDetailsService service;

    @Operation(summary = "Create a new payment ", description = "Method that creates a new Payment with status 200 OK")
    @PostMapping(path = "")
    public ResponseEntity<PaymentDetails> createNewPayment(@Valid @RequestBody PaymentDetails paymentDetails) {
        return ResponseEntity.ok(service.createNewPayment(paymentDetails));
    }
}
