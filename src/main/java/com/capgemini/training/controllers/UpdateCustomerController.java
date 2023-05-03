package com.capgemini.training.controllers;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.services.UpdateCustomerService;
import javax.validation.Valid;
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
  public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody @Valid CustomerDTO customer) {
    return ResponseEntity.ok(service.updateCustomer(customer));
  }
}
