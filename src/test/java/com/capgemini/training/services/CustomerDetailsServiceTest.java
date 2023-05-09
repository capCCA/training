package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.dtos.DocumentType;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(CustomerDetailsServiceTest.class)
class CustomerDetailsServiceTest {

  private CustomerDTO customerDTO;
  private CustomerEntity customerEntity;
  @InjectMocks private CustomerDetailsService customerDetailsService;
  @Mock private CustomerRepository repository;

  @BeforeEach
  public void createData() {
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
    customerEntity =
        CustomerEntity.builder()
            .customerId("0999")
            .documentType("DNI")
            .documentNumber("123456789")
            .name("Luca")
            .surname("GARCIA")
            .lastname("LOPEZ")
            .country("ESP")
            .telephone(1234567)
            .creationDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();
  }

  @Test
  void getCustomerDetails_whenIdExist_shouldReturnCustomer() {
    when(repository.findById(any())).thenReturn(Optional.of(customerEntity));
    CustomerDTO response = customerDetailsService.getCustomerDetail("0999");
    assertEquals(customerDTO.getCustomerId(), response.getCustomerId());
  }

  @Test
  void getCustomerDetail_whenCustomerNoExist_shouldThrowNotFound() {
    when(repository.findById(customerDTO.getCustomerId())).thenReturn(Optional.empty());
    assertThrows(
        CustomerNotFoundException.class, () -> customerDetailsService.getCustomerDetail("000"));
  }
}
