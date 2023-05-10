package com.capgemini.training.controllers;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.services.DeleteCustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteCustomerControllerTest {

  private DeleteCustomerController controller;
  @Mock private DeleteCustomerService service;

  @BeforeEach
  void setUp() {
    controller = new DeleteCustomerController(service);
  }

  @Test
  @DisplayName("does not return anything if the user has been successfully deleted")
  void shouldReturnOKWhenIdExists() {
    doNothing().when(service).deleteCustomer(anyString());
    controller.deleteCustomer("0");
    verify(service).deleteCustomer(anyString());
  }

  @Test
  @DisplayName("throws 400 Bad Request if Id does not exists")
  void shouldThrowBadRequestWhenIdDoesNotExists() {
    doThrow(CustomerNotFoundException.class).when(service).deleteCustomer(anyString());
    assertThrows(CustomerNotFoundException.class, () -> service.deleteCustomer("null"));
  }
}
