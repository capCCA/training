package com.capgemini.training.controllers;

import com.capgemini.training.exceptions.CustomerNotFoundException;
import com.capgemini.training.services.DeleteCustomerService;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
      @PathVariable(name = "customerId") @NotBlank String customerId) {
    service.deleteCustomer(customerId);
    return ResponseEntity.ok().build();
  }
}
