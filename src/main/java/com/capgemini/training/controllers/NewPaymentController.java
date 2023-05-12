package com.capgemini.training.controllers;

import com.capgemini.training.models.PaymentRequest;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.services.NewPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payment")
@RequiredArgsConstructor
public class NewPaymentController {

  private final NewPaymentService newPaymentService;

  @PostMapping
  public ResponseEntity<PaymentResponse> addPayment(@RequestBody PaymentRequest paymentRequest) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(newPaymentService.addPayment(paymentRequest));
  }
}
