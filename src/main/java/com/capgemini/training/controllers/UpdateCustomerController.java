package com.capgemini.training.controllers;

import com.capgemini.training.exceptions.CustomerBadRequestException;
import com.capgemini.training.models.Customer;
import com.capgemini.training.services.UpdateCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
@RequiredArgsConstructor
public class UpdateCustomerController {
  private final UpdateCustomerService service;

  @PutMapping
  public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
    return service
        .updateCustomer(customer)
        .map(ResponseEntity::ok)
        .orElseThrow(
            () -> new CustomerBadRequestException("El usuario no existe en la base de datos"));
  }
}
