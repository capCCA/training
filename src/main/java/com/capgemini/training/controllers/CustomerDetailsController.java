package com.capgemini.training.controllers;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.services.CustomerDetailsService;
import javax.validation.constraints.NotBlank;
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
  public ResponseEntity<CustomerDTO> getDetailsCustomer(
      @PathVariable(name = "customerId") @NotBlank String customerId) {
    return ResponseEntity.ok(service.getCustomerDetail(customerId));
  }
}
