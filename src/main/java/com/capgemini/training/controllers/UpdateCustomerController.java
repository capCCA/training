package com.capgemini.training.controllers;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.exceptions.CustomError;
import com.capgemini.training.services.UpdateCustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

  @Operation(summary = "Update customer details")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = CustomerDTO.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "This id already exists in the database",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = CustomError.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "The id does not exist in the database",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = CustomError.class))
            })
      })
  @PutMapping
  public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody @Valid CustomerDTO customer) {
    return ResponseEntity.ok(service.updateCustomer(customer));
  }
}
