package com.capgemini.training.services;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.errors.CustomerBadRequestException;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(DeleteCustomerServiceTest.class)
class DeleteCustomerServiceTest {

  private CustomerDTO customerDTO;
  private CustomerEntity customerEntity;
  @InjectMocks private DeleteCustomerService service;
  @Mock private CustomerRepository repository;

  @Test
  void deleteCustomer() {
    CustomerRepository repositoryMock = mock(CustomerRepository.class);
    when(repository.existsById(anyString())).thenReturn(true);
    doNothing().when(repository).deleteById("0000");
    service.deleteCustomer("0000");
    verify(repository).deleteById(anyString());
  }

  @Test
  void addCustomer_BadRequest() {
    when(repository.existsById(anyString())).thenReturn(false);
    assertThrows(CustomerNotFoundException.class, () -> service.deleteCustomer(anyString()));
  }
}
