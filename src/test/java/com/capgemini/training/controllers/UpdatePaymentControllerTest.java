package com.capgemini.training.controllers;

import com.capgemini.training.models.PaymentRequest;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.services.UpdatePaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdatePaymentControllerTest {

  @InjectMocks private UpdatePaymentController updatePaymentController;
  @Mock private UpdatePaymentService updatePaymentService;

  @Test
  void addPayment() {
    PaymentRequest paymentRequest = PaymentRequest.builder().build();
    PaymentResponse expectedResponse = PaymentResponse.builder().build();

    when(updatePaymentService.updatePayment(any(PaymentRequest.class))).thenReturn(expectedResponse);

    var result = updatePaymentController.updatePayment(paymentRequest);
    assertEquals(expectedResponse, result.getBody());
  }
}
