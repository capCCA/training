package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.capgemini.training.errors.CustomerBadRequestException;
import com.capgemini.training.models.CustomerDetails;
import com.capgemini.training.models.DocumentType;
import com.capgemini.training.services.AddCustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class AddCustomerControllerTest {

  private AddCustomerController addCustomerController;
  @Mock private AddCustomerService addCustomerService;

  @BeforeEach
  void setUp() {
    addCustomerController = new AddCustomerController(addCustomerService);
  }

  @Test
  @DisplayName("Return 201 created if it has been added successfully")
  void shouldReturnCreatedWhenCustomerIsOk() {
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

    when(addCustomerService.addCustomer(customerDetails)).thenReturn(customerDetails);

    ResponseEntity<CustomerDetails> response = addCustomerController.addCustomer(customerDetails);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(customerDetails, response.getBody());
  }

  @Test
  @DisplayName("Throws 400 Bad Request if Id already exists")
  void shouldThrowBadRequestWhenIdAlreadyExists() {

    when(addCustomerService.addCustomer(any(CustomerDetails.class)))
        .thenThrow(CustomerBadRequestException.class);

    assertThrows(
        CustomerBadRequestException.class,
        () ->
            addCustomerController.addCustomer(
                CustomerDetails.builder()
                    .customerId("0999")
                    .documentType(DocumentType.DNI)
                    .documentNumber("123456789")
                    .name("null")
                    .surname("GARCIA")
                    .lastname("LOPEZ")
                    .country("ESP")
                    .telephone(1234567)
                    .build()));
  }
}
