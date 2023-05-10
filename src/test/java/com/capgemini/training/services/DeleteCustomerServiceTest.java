package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.repositories.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteCustomerServiceTest {
  @InjectMocks private DeleteCustomerService service;
  @Mock private CustomerRepository repository;

  @Test
  @DisplayName("does not return anything if the user has been successfully deleted")
  void shouldNotReturnNotingWhenIdExists() {
    when(repository.existsById(anyString())).thenReturn(true);
    doNothing().when(repository).deleteById("0000");

    service.deleteCustomer("0000");

    verify(repository).deleteById(anyString());
  }

  @Test
  @DisplayName("Throws 400 Bad Request if Id does not exists")
  void shouldThrowBadRequestWhenIdNotExist() {
    when(repository.existsById(anyString())).thenReturn(false);
    assertThrows(CustomerNotFoundException.class, () -> service.deleteCustomer(""));
  }
}
