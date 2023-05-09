package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.dtos.DocumentType;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.services.UpdateCustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@WebMvcTest(UpdateCustomerControllerTest.class)
class UpdateCustomerControllerTest {

  private CustomerDTO customerDTO;
  @InjectMocks private UpdateCustomerController controller;
  @Mock private UpdateCustomerService service;

  @BeforeEach
  public void createDto() {
    customerDTO =
        CustomerDTO.builder()
            .customerId("0999")
            .documentType(DocumentType.DNI)
            .documentNumber("123456789")
            .name("null")
            .surname("GARCIA")
            .lastname("LOPEZ")
            .country("ESP")
            .telephone(1234567)
            .build();
  }

  @Test
  void updateCustomer_whenParamsProvided_shouldReturnOK() {
    when(service.updateCustomer(any(CustomerDTO.class))).thenReturn(customerDTO);
    ResponseEntity<CustomerDTO> response = controller.updateCustomer(customerDTO);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(customerDTO, response.getBody());
  }

  @Test
  void updateCustomer_whenIdNoExist_shouldReturnNotFound() {
    when(service.updateCustomer(any(CustomerDTO.class))).thenThrow(CustomerNotFoundException.class);
    assertThrows(
        CustomerNotFoundException.class,
        () -> controller.updateCustomer(CustomerDTO.builder().build()));
  }
}
