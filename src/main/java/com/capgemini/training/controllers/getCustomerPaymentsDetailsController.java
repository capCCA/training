package com.capgemini.training.controllers;

import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.services.getCustomerPaymentsDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class getCustomerPaymentsDetailsController {

  private final getCustomerPaymentsDetailsService getCustomerPaymentsDetailsService;

  @Operation(summary = "Create a new payment")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Payments were correctly listed",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = CustomerEntity.class))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Error while listing payments",
            content = @Content)
      })
  @GetMapping("/getPaymentsByCustomer/{customerId}")
  public ResponseEntity<List<PaymentDetailsResponse>> getCustomerPaymentsDetails(
      @PathVariable @Valid @NotBlank(message = "El ID de cliente introducido no puede estar vacío")
          Long customerId) {

    return ResponseEntity.status(HttpStatus.OK)
        .body(getCustomerPaymentsDetailsService.getCustomerPaymentsDetails( customerId ));
  }
}
