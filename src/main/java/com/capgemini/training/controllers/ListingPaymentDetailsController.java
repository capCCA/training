package com.capgemini.training.controllers;

import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.services.ListingPaymentDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class ListingPaymentDetailsController {

    private final ListingPaymentDetailsService listingPaymentDetailsService;

    @Operation(summary = "Create a new payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payments were correctly listed",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerEntity.class)) }),
            @ApiResponse(responseCode = "500", description = "Error while listing payments",
                    content = @Content) })
    @GetMapping("/listing")
    public ResponseEntity<List<PaymentDetailsResponse>> listPaymentsDetails(){

        return ResponseEntity.status(HttpStatus.OK).body( listingPaymentDetailsService.listPaymentDetails() );

    }
}
