package com.capgemini.training.payment.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.config.PaymentMapper;
import com.capgemini.training.payment.dto.PaymentDto;
import com.capgemini.training.payment.service.PaymentGetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Payment", description = "API of PaymentGetController")
@RequestMapping(path = "/payments")
@RestController
@RequiredArgsConstructor
@Transactional
public class PaymentGetController {

    public final PaymentGetService service;

    @Operation(summary = "Find all ", description = "Method that returns a List of Payments")
    @GetMapping(path = "")
    List<PaymentDto> findAll() {
        return service.findAll().stream().map(PaymentMapper::toDto).collect(Collectors.toList());
    }

    @Operation(summary = "Find ", description = "Method that returns a Payment")
    @GetMapping(path = "/{paymentId}")
    PaymentDto findById(@PathVariable("paymentId") Long id) {
        return PaymentMapper.toDto(service.findById(id));
    }
}
