package com.capgemini.training.controllers;

import com.capgemini.training.models.PaymentDetails;
import com.capgemini.training.repository.models.CustomerEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/payments")
public class PaymentDetailsController {

    @Operation(summary = "Create a new payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment was correctly saved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Payment object is not correct",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error while inserting Payment",
                    content = @Content), })
    @PostMapping("/")
    public ResponseEntity createNewPayment(@Valid @RequestBody @NotNull(message="El objeto payment enviado es incorrecto") PaymentDetails paymentDetails ) {

        return null;

    }

}
