package com.capgemini.training.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.api.exceptions.CustomerNotFoundException;
import com.capgemini.training.api.repository.CustomerRepository;
import com.capgemini.training.api.service.DeleteCustomerDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DeleteCustomerDetailsServiceTest {

  @Mock private CustomerRepository userRepository;

  @InjectMocks private DeleteCustomerDetailsService deleteCustomerDetailsService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void deleteExistingCustomer() {
    String customerId = "12345";
    when(userRepository.existsById(customerId)).thenReturn(true);
    doNothing().when(userRepository).deleteById(customerId);

    assertDoesNotThrow(() -> deleteCustomerDetailsService.delete(customerId));

    verify(userRepository).existsById(customerId);
    verify(userRepository).deleteById(customerId);
  }

  @Test
  void deleteNonExistingCustomer() {
    String customerId = "12345";
    when(userRepository.existsById(customerId)).thenReturn(false);

    assertThrows(
        CustomerNotFoundException.class, () -> deleteCustomerDetailsService.delete(customerId));

    verify(userRepository).existsById(customerId);
    verify(userRepository, never()).deleteById(customerId);
  }
}
