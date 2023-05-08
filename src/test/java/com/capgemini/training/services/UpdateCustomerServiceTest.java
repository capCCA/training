package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.dtos.DocumentType;
import com.capgemini.training.errors.CustomerBadRequestException;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(UpdateCustomerServiceTest.class)
class UpdateCustomerServiceTest {

  private CustomerDTO customerDTO;
  private CustomerEntity customer;

  @InjectMocks private UpdateCustomerService service;

  @Mock private CustomerRepository repository;

  @BeforeEach
  public void createDto() {
    customerDTO =
        CustomerDTO.builder()
            .customerId("0999")
            .documentType(DocumentType.DNI)
            .documentNumber("123456789")
            .name("Luca")
            .surname("GARCIA")
            .lastname("LOPEZ")
            .country("ESP")
            .telephone(1234567)
            .build();
    customer =
        CustomerEntity.builder()
            .customerId("0999")
            .documentType("DNI")
            .documentNumber("123456789")
            .name("Luca")
            .surname("GARCIA")
            .lastname("LOPEZ")
            .country("ESP")
            .telephone(1234567)
            .creationDate(new Date())
            .updateDate(new Date())
            .build();
  }

  @Test
  void updateCustomer() {
    when(repository.existsById(anyString())).thenReturn(true);
    when(repository.save(any(CustomerEntity.class))).thenReturn(customer);
    CustomerDTO response = service.updateCustomer(customerDTO);
    assertEquals(customerDTO.getCustomerId(), response.getCustomerId());
  }

  @Test
  void addCustomer_BadRequest() {
    when(repository.existsById(customerDTO.getCustomerId())).thenReturn(false);
    assertThrows(CustomerNotFoundException.class, () -> service.updateCustomer(customerDTO));
  }
}
