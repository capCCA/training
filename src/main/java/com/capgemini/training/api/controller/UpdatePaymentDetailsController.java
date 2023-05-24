package com.capgemini.training.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.api.model.PaymentDetails;
import com.capgemini.training.api.model.UpdatePaymentRequest;
import com.capgemini.training.api.service.UpdatePaymentDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "PaymentEntity", description = "API of PaymentGetController")
@RestController
@RequestMapping(path = "/payments")
@RequiredArgsConstructor
@Transactional
public class UpdatePaymentDetailsController {

    public final UpdatePaymentDetailsService service;

    @Operation(summary = "Update payment ", description = "Method that updates a payment with 200 OK")
    @PutMapping(path = "/{paymentId}")
    public ResponseEntity<PaymentDetails> updatePayment(@PathVariable("paymentId") Long paymentId,
            @Valid @RequestBody UpdatePaymentRequest paymentDetails) {
        return ResponseEntity.ok(service.updatePayment(paymentId, paymentDetails));
    }

}
