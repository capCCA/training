package com.capgemini.training.controllers;

import com.capgemini.training.exceptions.CustomerBadRequestException;
import com.capgemini.training.models.Customer;
import com.capgemini.training.services.AddCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
@RequiredArgsConstructor
public class AddCustomerController {

  private final AddCustomerService service;

  @PostMapping
  public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
    if (customer == null) {
      throw new CustomerBadRequestException(
          "El usuario introducido no es valido, revise los campos introducidos");
    }
    return service
        .addCustomer(customer)
        .map(ResponseEntity::ok)
        .orElseThrow(
            () ->
                new CustomerBadRequestException(
                    "Ya existe un usuario en la base de datos con ese id"));
  }
}
