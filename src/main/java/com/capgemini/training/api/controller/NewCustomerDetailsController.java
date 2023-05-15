package com.capgemini.training.api.controller;

import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.service.NewCustomerDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "CustomerEntity", description = "API of UserPostController")
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Log
public class NewCustomerDetailsController {

  public final NewCustomerDetailsService userService;

  /**
   * Method that saves a new CustomerEntity: creates a user
   *
   * @param  dto {@link CustomerDetails}
   * @return {@link ResponseEntity } of {@link CustomerDetails} with status 201 CREATED
   */
  @Operation(summary = "Save ", description = "Method that saves a CustomerEntity")
  @PostMapping(
      path = "",
      consumes = {"application/json"})
  public ResponseEntity<CustomerDetails> save(@Valid @RequestBody CustomerDetails dto) {
    CustomerDetails savedDto = userService.save(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
  }
}

// Note: the same
// return ResponseEntity.status(HttpStatus.OK).body(userService.save(dto));
//
//  return ResponseEntity.ok(userService.save(dto));
//
//
