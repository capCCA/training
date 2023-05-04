package com.capgemini.training.controllers;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.errors.CustomError;
import com.capgemini.training.services.AddCustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.MediaType;
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

  @Operation(
      summary = "Add a customer",
      description = "Service for create a new customer information.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "CustomerDetails",
            content = {
              @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  schema = @Schema(implementation = CustomerDTO.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "This id already exists in the database",
            content = {
              @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  schema = @Schema(implementation = CustomError.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "The id does not exist in the database",
            content = {
              @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  schema = @Schema(implementation = CustomError.class))
            })
      })
  @PostMapping
  public ResponseEntity<CustomerDTO> addCustomer(
      @RequestBody @ParameterObject @Valid CustomerDTO customer) {
    return ResponseEntity.ok(service.addCustomer(customer));
  }
}
