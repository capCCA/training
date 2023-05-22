package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.exceptions.CustomerDetailsException;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.services.getCustomerPaymentsDetailsService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class getCustomerPaymentsDetailsControllerTest {

  @InjectMocks getCustomerPaymentsDetailsController getCustomerPaymentsDetailsController;
  @Mock getCustomerPaymentsDetailsService getCustomerPaymentsDetailsService;

  private PaymentDetailsResponse paymentDetailsResponse;
  private CustomerEntity customerEntity;

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
  }

  @Test
  void getPaymentDetailsByCustomerId() {

    List<PaymentDetailsResponse> serviceResponse = Arrays.asList(paymentDetailsResponse);

    Long customerId = 1L;

    when(getCustomerPaymentsDetailsService.getCustomerPaymentsDetails(customerId))
        .thenReturn(serviceResponse);

    ResponseEntity<List<PaymentDetailsResponse>> controllerResponse =
        getCustomerPaymentsDetailsController.getCustomerPaymentsDetails(customerId);

    assertEquals(HttpStatus.OK, controllerResponse.getStatusCode());
    assertEquals(controllerResponse.getBody(), serviceResponse);
    assertNotNull(serviceResponse);
    verify(getCustomerPaymentsDetailsService).getCustomerPaymentsDetails(any());
  }

  @Test
  void getPaymentsDetailsByCustomerErrorWhileReturning() {

    Long customerId = 1L;

    when(getCustomerPaymentsDetailsService.getCustomerPaymentsDetails(customerId))
        .thenThrow(CustomerDetailsException.class);

    assertThrows(CustomerDetailsException.class, ()-> getCustomerPaymentsDetailsController.getCustomerPaymentsDetails(customerId));
    verify(getCustomerPaymentsDetailsService).getCustomerPaymentsDetails(any());
  }

}
