package com.capgemini.training.controller;

import com.capgemini.training.config.PaymentMapper;
import com.capgemini.training.dto.PaymentDto;
import com.capgemini.training.entity.Payment;
import com.capgemini.training.service.PaymentGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Payment", description = "API of PaymentGetController")
@RestController
@RequestMapping(path = "/payments")
@RequiredArgsConstructor
@Transactional
public class PaymentGetController {

  public final PaymentGetService service;

  @Operation(
      summary = "Find all ",
      description = "Method that returns a List of Payments with status 200 OK")
  @GetMapping(path = "")
  ResponseEntity<List<PaymentDto>> findAll() {
    return ResponseEntity.ok(
        service.findAll().stream().map(PaymentMapper::toDto).collect(Collectors.toList()));
  }

  @Operation(
      summary = "Find ",
      description = "Method that returns a Payment with status OK or NOT_FOUND")
  @GetMapping(path = "/{paymentId}")
  ResponseEntity<PaymentDto> findById(@PathVariable("paymentId") Long id) {
    Optional<Payment> optData = service.findById(id);
    return optData
        .map(pay -> ResponseEntity.ok(PaymentMapper.toDto(pay)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}

//  Notas:
//  PaymentDto old_findById(@PathVariable("paymentId") Long id) {
//    return PaymentMapper.toDto(service.findById(id));
//  }
