package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.capgemini.training.models.CustomerDetails;
import com.capgemini.training.models.DocumentType;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.services.CustomerDetailsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class CustomerDetailsControllerTest {

  @InjectMocks private CustomerDetailsController controller;
  @Mock private CustomerDetailsService service;

  @Test
  @DisplayName("Return 200 OK if id exits")
  void shouldReturnOKWhenIdExists() {
    CustomerDetails customerDetails =
        CustomerDetails.builder()
            .customerId("0999")
            .documentType(DocumentType.DNI)
            .documentNumber("123456789")
            .name("Luca")
            .surname("GARCIA")
            .lastname("LOPEZ")
            .country("ESP")
            .telephone(1234567)
            .build();

    when(service.getCustomerDetail(anyString())).thenReturn(customerDetails);

    ResponseEntity<CustomerDetails> response = controller.getCustomerDetails("0");

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(customerDetails, response.getBody());
  }

  @Test
  @DisplayName("Throws 404 NotFound if Id does not exists")
  void shouldThrowNotFoundWhenCustomerNotExists() {
    when(service.getCustomerDetail(anyString())).thenThrow(CustomerNotFoundException.class);

    assertThrows(CustomerNotFoundException.class, () -> controller.getCustomerDetails("0"));
  }
}
