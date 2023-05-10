package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.models.CustomerDetails;
import com.capgemini.training.models.DocumentType;
import com.capgemini.training.repositories.CustomerRepository;
import com.capgemini.training.repositories.models.CustomerEntity;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerServiceTest {

  private UpdateCustomerService service;
  @Mock private CustomerRepository repository;

  @BeforeEach
  void setUp() {
    service = new UpdateCustomerService(repository);
  }

  @Test
  @DisplayName("Return customer if it has been update successfully")
  void shouldReturnCustomerWhenCustomerIsValid() {
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
    CustomerEntity customer =
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
    when(repository.existsById(anyString())).thenReturn(true);
    when(repository.save(any(CustomerEntity.class))).thenReturn(customer);
    CustomerDetails response = service.updateCustomer(customerDetails);
    assertEquals(customerDetails.getCustomerId(), response.getCustomerId());
  }

  @Test
  @DisplayName("Throws 400 Bad Request if Id does not exists")
  void shouldThrowsNotFoundWhenIdNotExists() {
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

    when(repository.existsById(anyString())).thenReturn(false);
    assertThrows(CustomerNotFoundException.class, () -> service.updateCustomer(customerDetails));
  }
}
