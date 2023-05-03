package com.capgemini.training.controllers;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.services.AddCustomerService;
import javax.validation.Valid;
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
  public ResponseEntity<CustomerDTO> addCustomer(@RequestBody @Valid CustomerDTO customer) {
    return ResponseEntity.ok(service.addCustomer(customer));
  }
}
