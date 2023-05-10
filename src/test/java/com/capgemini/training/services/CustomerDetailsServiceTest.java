package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.models.CustomerDetails;
import com.capgemini.training.models.DocumentType;
import com.capgemini.training.repositories.CustomerRepository;
import com.capgemini.training.repositories.models.CustomerEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerDetailsServiceTest {

  private CustomerDetailsService customerDetailsService;
  @Mock private CustomerRepository repository;

  @BeforeEach
  void setUp() {
    customerDetailsService = new CustomerDetailsService(repository);
  }

  @Test
  @DisplayName("return customer if id exits")
  void shouldReturnCustomerWhenIdExists() {
    CustomerEntity customerEntity =
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

    when(repository.findById(anyString())).thenReturn(Optional.of(customerEntity));
    CustomerDetails response = customerDetailsService.getCustomerDetail("0999");
    assertEquals(customerDetails.getCustomerId(), response.getCustomerId());
  }

  @Test
  @DisplayName("throws 404 NotFound if Id does not exists")
  void shouldThrowNotFoundWhenIdNotExists() {
    when(repository.findById(anyString())).thenReturn(Optional.empty());
    assertThrows(
        CustomerNotFoundException.class, () -> customerDetailsService.getCustomerDetail("000"));
  }
}
