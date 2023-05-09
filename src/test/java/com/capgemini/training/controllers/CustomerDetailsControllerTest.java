package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.dtos.DocumentType;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.services.CustomerDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@WebMvcTest(CustomerDetailsControllerTest.class)
class CustomerDetailsControllerTest {

  private CustomerDTO customerDTO;
  @InjectMocks private CustomerDetailsController controller;
  @Mock private CustomerDetailsService service;

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
  void getCustomerDetails_whenIdExist_shouldReturnOK() {
    when(service.getCustomerDetail(anyString())).thenReturn(customerDTO);

    ResponseEntity<CustomerDTO> response = controller.getCustomerDetails("0");

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(customerDTO, response.getBody());
  }

  @Test
  void getCustomerDetail_whenCustomerNoExist_shouldThrowNotFound() throws Exception {
    when(service.getCustomerDetail(anyString())).thenThrow(CustomerNotFoundException.class);

    assertThrows(CustomerNotFoundException.class, () -> controller.getCustomerDetails("0"));
  }
}
