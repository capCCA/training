package com.capgemini.training.controllers;

import com.capgemini.training.exceptions.CustomerNotFoundException;
import com.capgemini.training.services.DeleteCustomerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/customer")
public class DeleteCustomerController {

  private final DeleteCustomerService service;

  @DeleteMapping(path = "/{customerId}")
  public ResponseEntity<String> deleteCustomer(
      @PathVariable(name = "customerId") @NonNull String customerId) {
    if (service.deleteCustomer(customerId)) {
      return ResponseEntity.ok(
          "El usuario con id " + customerId + " se ha eliminado correctamente");
    }
    throw new CustomerNotFoundException();
  }
}
