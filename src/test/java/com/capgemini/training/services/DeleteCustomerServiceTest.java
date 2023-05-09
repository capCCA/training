package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(DeleteCustomerServiceTest.class)
class DeleteCustomerServiceTest {

  private CustomerDTO customerDTO;
  private CustomerEntity customerEntity;
  @InjectMocks private DeleteCustomerService service;
  @Mock private CustomerRepository repository;

  @Test
  void deleteCustomer_whenIdExist_shouldReturnOK() {
    when(repository.existsById(anyString())).thenReturn(true);
    doNothing().when(repository).deleteById("0000");

    service.deleteCustomer("0000");

    verify(repository).deleteById(anyString());
  }

  @Test
  void deleteCustomer_whenIdDoesNotExist_shouldThrowBadRequest() {
    when(repository.existsById(anyString())).thenReturn(false);
    assertThrows(CustomerNotFoundException.class, () -> service.deleteCustomer(""));
  }
}
