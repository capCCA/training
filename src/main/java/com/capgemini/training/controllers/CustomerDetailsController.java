package com.capgemini.training.controllers;

import com.capgemini.training.models.CustomerDetails;
import com.capgemini.training.errors.CustomError;
import com.capgemini.training.services.CustomerDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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

  @Operation(summary = "Get customer details")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            content = {
              @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  schema = @Schema(implementation = CustomerDetails.class))
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
  @GetMapping(path = "/{customerId}")
  public ResponseEntity<CustomerDetails> getCustomerDetails(
      @PathVariable(name = "customerId") @NotBlank String customerId) {
    return ResponseEntity.ok(service.getCustomerDetail(customerId));
  }
}
