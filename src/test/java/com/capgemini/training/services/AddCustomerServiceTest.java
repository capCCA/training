package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.dtos.DocumentType;
import com.capgemini.training.errors.CustomerBadRequestException;
import com.capgemini.training.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(AddCustomerServiceTest.class)
class AddCustomerServiceTest {

  private CustomerDTO customerDTO;
  private CustomerEntity customer;
  @InjectMocks private AddCustomerService addCustomerService;
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
            .creationDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();
  }

  @Test
  void addCustomer_whenCustomerProvided_shouldReturnCustomer() {
    when(repository.existsById(customerDTO.getCustomerId())).thenReturn(false);
    when(repository.save(any(CustomerEntity.class))).thenReturn(customer);

    CustomerDTO response = addCustomerService.addCustomer(customerDTO);

    assertEquals(customerDTO.getCustomerId(), response.getCustomerId());
  }

  @Test
  void addCustomer_BadRequest() {
    when(repository.existsById(customerDTO.getCustomerId())).thenReturn(true);
    assertThrows(
        CustomerBadRequestException.class, () -> addCustomerService.addCustomer(customerDTO));
  }
}
