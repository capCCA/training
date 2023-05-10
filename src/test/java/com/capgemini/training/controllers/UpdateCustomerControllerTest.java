package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.capgemini.training.models.CustomerDetails;
import com.capgemini.training.models.DocumentType;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.services.UpdateCustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerControllerTest {

  @InjectMocks private UpdateCustomerController controller;
  @Mock private UpdateCustomerService service;

  @Test
  @DisplayName("Return 200 OK if it has been update successfully")
  void shouldReturnOKWhenParamsProvided() {
    CustomerDetails customerDetails =
        CustomerDetails.builder()
            .customerId("0999")
            .documentType(DocumentType.DNI)
            .documentNumber("123456789")
            .name("null")
            .surname("GARCIA")
            .lastname("LOPEZ")
            .country("ESP")
            .telephone(1234567)
            .build();

    when(service.updateCustomer(any(CustomerDetails.class))).thenReturn(customerDetails);
    ResponseEntity<CustomerDetails> response = controller.updateCustomer(customerDetails);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(customerDetails, response.getBody());
  }

  @Test
  void shouldReturnNotFoundWhenIdNoExist() {
    when(service.updateCustomer(any(CustomerDetails.class)))
        .thenThrow(CustomerNotFoundException.class);
    assertThrows(
        CustomerNotFoundException.class,
        () -> controller.updateCustomer(CustomerDetails.builder().build()));
  }
}
