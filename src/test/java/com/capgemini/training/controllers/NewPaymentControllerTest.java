package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.capgemini.training.models.PaymentRequest;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.services.NewPaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NewPaymentControllerTest {

  @InjectMocks private NewPaymentController newPaymentController;
  @Mock private NewPaymentService newPaymentService;

  @Test
  void addPayment() {
    PaymentRequest paymentRequest = PaymentRequest.builder().build();
    PaymentResponse expectedResponse = PaymentResponse.builder().build();
    when(newPaymentService.addPayment(any(PaymentRequest.class))).thenReturn(expectedResponse);
    var result = newPaymentController.addPayment(paymentRequest);
    assertEquals(expectedResponse, result.getBody());
  }
}
