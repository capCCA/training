package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.exceptions.PaymentDetailsException;
import com.capgemini.training.models.PaymentDetailsRequest;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.services.NewPaymentDetailsService;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class NewPaymentDetailsControllerTest {

  @InjectMocks private NewPaymentDetailsController newPaymentDetailsController;
  @Mock private NewPaymentDetailsService newPaymentDetailsService;

  private PaymentDetailsResponse paymentDetailsResponse;
  private CustomerEntity customerEntity;
  private PaymentDetailsRequest paymentDetailsRequest;

  @BeforeEach
  void setUp() {
    customerEntity =
        CustomerEntity.builder()
            .customerId("1")
            .name("Albert")
            .surname("Romero")
            .country("USA")
            .build();

    paymentDetailsResponse =
        PaymentDetailsResponse.builder()
            .paymentId(1L)
            .customer(customerEntity)
            .paymentType("Credit")
            .amount(BigDecimal.valueOf(100.0))
            .creationDate(LocalDate.now())
            .updateDate(LocalDate.ofEpochDay(01 - 02 - 2023))
            .build();

    paymentDetailsRequest =
        PaymentDetailsRequest.builder()
            .paymentId(1L)
            .customerId("1")
            .beneficiaryId("Ben1")
            .paymentType("Credit")
            .amount(BigDecimal.valueOf(100.0))
            .creationDate(LocalDate.now())
            .updateDate(LocalDate.ofEpochDay(01 - 02 - 2023))
            .build();
  }

  @Test
  void createNewPaymentSuccess() {

    Long customerId = 1L;

    when(newPaymentDetailsService.createNewPayment(paymentDetailsRequest))
        .thenReturn(paymentDetailsResponse);

    ResponseEntity<PaymentDetailsResponse> controllerResponse =
        newPaymentDetailsController.createNewPayment(paymentDetailsRequest);

    assertNotNull(controllerResponse);
    assertEquals(HttpStatus.OK, controllerResponse.getStatusCode());
    assertEquals(controllerResponse.getBody(), paymentDetailsResponse);
    verify(newPaymentDetailsService).createNewPayment(any());
  }

  @Test
  void createNewPaymentSomeDetailsAreWrong() {
    Long customerId = 1L;

    when(newPaymentDetailsService.createNewPayment(paymentDetailsRequest))
        .thenThrow(new PaymentDetailsException("Algun detalle no se ha insertado correctamente"));

    assertThrows(
        PaymentDetailsException.class,
        () -> newPaymentDetailsController.createNewPayment(paymentDetailsRequest));
  }
}
