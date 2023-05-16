package com.capgemini.training.controllers;

import com.capgemini.training.repository.models.CustomerEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class ListingPaymentDetailsController {
    @Operation(summary = "Create a new payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payments were correctly listed",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerEntity.class)) }),
            @ApiResponse(responseCode = "500", description = "Error while listing payments",
                    content = @Content) })
    @GetMapping("/listing")
    public List<ResponseEntity> listPaymentsDetails(){

        return null;

    }
}
