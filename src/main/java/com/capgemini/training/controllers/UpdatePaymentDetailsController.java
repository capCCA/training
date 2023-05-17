package com.capgemini.training.controllers;

import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentDetailsRequest;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.services.UpdatePaymentDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class UpdatePaymentDetailsController {

    private final UpdatePaymentDetailsService updatePaymentDetailsService;
    private final PaymentMapper paymentMapper;

    @Operation(summary = "Update a payment")
    //Documentating Status codes
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment was correctly updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerEntity.class)) }),
            @ApiResponse(responseCode = "400", description = "Payment was not updated as 'ID' provided does not match with an existing payment",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error while saving payment on system. Contact your administrator ",
                    content = @Content) })

    @PutMapping("/")
    public ResponseEntity<PaymentDetailsResponse> updateUser(@Valid @RequestBody @NotNull(message="El objeto payment enviado es incorrecto") PaymentDetailsRequest paymentDetailsRequest) {

        return ResponseEntity.ok( updatePaymentDetailsService.updatePayment(paymentDetailsRequest));

    }

}
