package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.dtos.DocumentType;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.services.DeleteCustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(DeleteCustomerControllerTest.class)
class DeleteCustomerControllerTest {

  private CustomerDTO customerDTO;

  @InjectMocks private DeleteCustomerController controller;

  @Mock private DeleteCustomerService service;

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
  void deleteCustomer_whenIdExist_shouldReturnOK() {
    doNothing().when(service).deleteCustomer(anyString());
    controller.deleteCustomer("0");
    verify(service).deleteCustomer(anyString());
  }

  @Test
  void deleteCustomer_whenIdDoesNotExist_shouldThrowBadRequest() {
    doThrow(CustomerNotFoundException.class).when(service).deleteCustomer(anyString());
    assertThrows(CustomerNotFoundException.class, () -> service.deleteCustomer("null"));
  }
}
