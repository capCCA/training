package com.capgemini.training.controllers;

import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.services.ListPaymentService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListPaymentsControllerTest {
  @InjectMocks private ListPaymentsController listPaymentsController;
  @Mock private ListPaymentService listPaymentService;

  @Test
  @DisplayName("")
  void getAllPaymentByCustomerId() {
    List<PaymentResponse> expectedPaymentsResponse = List.of(PaymentResponse.builder().build());
    when(listPaymentService.getAllPaymentsByCustomerId(anyString()))
        .thenReturn(expectedPaymentsResponse);
    var result = listPaymentsController.getAllPaymentByCustomerId("1");
    assertEquals(expectedPaymentsResponse, result.getBody());
  }

  @Test
  @DisplayName("")
  void getAllPayments() {
    final List<PaymentResponse> expectedPaymentsResponse = new ArrayList<>();
    expectedPaymentsResponse.add(PaymentResponse.builder().build());
    when(listPaymentService.getAllPayments())
            .thenReturn(expectedPaymentsResponse);
    var result = listPaymentsController.getAllPayments();
    assertEquals(expectedPaymentsResponse, result.getBody());
    assertEquals(1,result.getBody().size());
  }
}
