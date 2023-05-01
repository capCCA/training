package com.capgemini.training.controllers;

import com.capgemini.training.exceptions.CustomerNotFoundException;
import com.capgemini.training.models.Customer;
import com.capgemini.training.services.CustomerDetailsService;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
@RequiredArgsConstructor
public class CustomerDetailsController {

  private final CustomerDetailsService service;

  @GetMapping(path = "/{customerId}")
  public ResponseEntity<Customer> getDetailsCustomer(
      @PathVariable(name = "customerId") @NonNull String customerId) {
    Optional<Customer> response = service.getCustomerDetail(customerId);
    return response.map(ResponseEntity::ok).orElseThrow(CustomerNotFoundException::new);
  }
}
