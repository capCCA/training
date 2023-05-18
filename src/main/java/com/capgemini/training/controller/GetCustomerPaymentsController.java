package com.capgemini.training.controller;

import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.service.GetPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/paymentsUser")
@RestController
@RequiredArgsConstructor
public class GetCustomerPaymentsController {

    private final GetPaymentService getPaymentService;



    @GetMapping(value = "/{customerId}")
    public ResponseEntity<PaymentDto> get(@PathVariable("customerId") String customerId) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body((PaymentDto) this.getPaymentService.get(customerId));

        } catch (UserNotFoundException e) {
            return ResponseEntity.noContent().build();

        }
    }


}