package com.capgemini.training.controllers;

import com.capgemini.training.errors.CustomError;
import com.capgemini.training.services.DeleteCustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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

  @Operation(summary = "Delete customer by Id")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200"),
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
  @DeleteMapping(path = "/{customerId}")
  public ResponseEntity<Void> deleteCustomer(
      @PathVariable("customerId") @NotBlank String customerId) {
    service.deleteCustomer(customerId);
    return ResponseEntity.ok().build();
  }
}
