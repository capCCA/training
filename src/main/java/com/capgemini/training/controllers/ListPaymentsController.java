package com.capgemini.training.controllers;

import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.services.ListPaymentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payment")
@RequiredArgsConstructor
public class ListPaymentsController {

  private final ListPaymentService listPaymentService;

  @GetMapping("/{customerId}")
  public ResponseEntity<List<PaymentResponse>> getAllPaymentByCustomerId(
      @PathVariable(name = "customerId") String customerId) {
    return ResponseEntity.ok(listPaymentService.getAllPaymentsByCustomerId(customerId));
  }

  @GetMapping
  public ResponseEntity<List<PaymentResponse>> getAllPayments() {
    return ResponseEntity.ok(listPaymentService.getAllPayments());
  }
}
