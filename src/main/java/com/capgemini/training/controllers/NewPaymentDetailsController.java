package com.capgemini.training.controllers;

import com.capgemini.training.models.PaymentDetailsRequest;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.services.NewPaymentDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class NewPaymentDetailsController {

    private final NewPaymentDetailsService newPaymentDetailsService;

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
    public ResponseEntity<PaymentDetailsResponse> createNewPayment(@Valid @RequestBody @NotNull(message="El objeto payment enviado es incorrecto") PaymentDetailsRequest paymentDetailsRequest) {

        return ResponseEntity.status(HttpStatus.OK).body( newPaymentDetailsService.createNewPayment(paymentDetailsRequest));

    }

}
