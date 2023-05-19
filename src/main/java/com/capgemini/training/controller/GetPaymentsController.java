package com.capgemini.training.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.service.GetPaymentService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/payments")
@RestController
@RequiredArgsConstructor
public class GetPaymentsController {

    private final GetPaymentService getPaymentService;

    @GetMapping
    public List<PaymentDto> findAll() {

        List<PaymentDto> listPayments = this.getPaymentService.findAll();
        return listPayments;

        //return getPaymentService.stream().map(e -> mapper.map(e, PaymentDto.class)).collect(Collectors.toList());
    }



}