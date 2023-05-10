package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.capgemini.training.models.CustomerDetails;
import com.capgemini.training.models.DocumentType;
import com.capgemini.training.errors.CustomerBadRequestException;
import com.capgemini.training.repositories.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AddCustomerServiceTest {

  @InjectMocks private AddCustomerService addCustomerService;
  @Mock private CustomerRepository repository;

  @Test
  @DisplayName("Return customer if it has been added successfully")
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

    when(repository.existsById(anyString())).thenReturn(false);
    when(repository.save(any(CustomerEntity.class))).thenReturn(customer);

    CustomerDetails response = addCustomerService.addCustomer(customerDetails);

    assertEquals(customerDetails.getCustomerId(), response.getCustomerId());
  }

  @Test
  @DisplayName("Throws 400 Bad Request if Id already exists")
  void shouldThrowBadRequestWhenIdAlreadyExists() {
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

    when(repository.existsById(anyString())).thenReturn(true);
    assertThrows(
        CustomerBadRequestException.class, () -> addCustomerService.addCustomer(customerDetails));
  }
}
