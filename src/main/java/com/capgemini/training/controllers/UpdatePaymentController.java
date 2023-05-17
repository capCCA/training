package com.capgemini.training.controllers;

import com.capgemini.training.models.PaymentRequest;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.services.UpdatePaymentService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payment")
@RequiredArgsConstructor
public class UpdatePaymentController {

  private final UpdatePaymentService updatePaymentService;

  @PutMapping
  public ResponseEntity<PaymentResponse> updatePayment(
      @Valid @RequestBody PaymentRequest paymentRequest) {
    return ResponseEntity.ok(updatePaymentService.updatePayment(paymentRequest));
  }
}
