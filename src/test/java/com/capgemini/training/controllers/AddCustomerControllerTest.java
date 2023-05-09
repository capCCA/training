package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.dtos.DocumentType;
import com.capgemini.training.errors.CustomerBadRequestException;
import com.capgemini.training.services.AddCustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@WebMvcTest(AddCustomerControllerTest.class)
class AddCustomerControllerTest {

  private CustomerDTO customerDTO;
  @InjectMocks private AddCustomerController addCustomerController;
  @Mock private AddCustomerService addCustomerService;

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
  void addCustomer_whenCustomerProvidedOk_shouldReturnOK() {

    when(addCustomerService.addCustomer(customerDTO)).thenReturn(customerDTO);

    ResponseEntity<CustomerDTO> response = addCustomerController.addCustomer(customerDTO);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(customerDTO, response.getBody());
  }

  @Test
  void addCustomer_whenIdAlreadyExist_shouldThrowBadRequest() throws Exception {
    when(addCustomerService.addCustomer(any(CustomerDTO.class)))
        .thenThrow(CustomerBadRequestException.class);

    assertThrows(
        CustomerBadRequestException.class, () -> addCustomerController.addCustomer(customerDTO));
  }
}
