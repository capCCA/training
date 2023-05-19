package com.capgemini.training.controller;

import javax.validation.Valid;

import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.service.UpdatePaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/payment")
public class UpdatePaymentController {

    public final UpdatePaymentService updatePaymentService;

    @PutMapping(path = "/{paymentId}")
    public ResponseEntity<PaymentDto> update(@Valid @PathVariable(name = "paymentId") Long paymentId,
            @RequestBody PaymentDto dto) throws Exception {

        return ResponseEntity.ok(updatePaymentService.update(paymentId, dto));

    }
}