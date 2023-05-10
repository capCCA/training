package com.capgemini.training.controller;

import com.capgemini.training.config.PaymentMapper;
import com.capgemini.training.dto.PaymentDetails;
import com.capgemini.training.entity.PaymentEntity;
import com.capgemini.training.service.PaymentDetailsService;
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

@Tag(name = "PaymentEntity", description = "API of PaymentGetController")
@RestController
@RequestMapping(path = "/payments")
@RequiredArgsConstructor
@Transactional
public class PaymentDetailsController {

  public final PaymentDetailsService service;

  @Operation(
      summary = "Find all ",
      description = "Method that returns a List of Payments with status 200 OK")
  @GetMapping(path = "")
  ResponseEntity<List<PaymentDetails>> findAll() {
    return ResponseEntity.ok(
        service.findAll().stream().map(PaymentMapper::toDto).collect(Collectors.toList()));
  }

  @Operation(
      summary = "Find ",
      description = "Method that returns a PaymentEntity with status OK or NOT_FOUND")
  @GetMapping(path = "/{paymentId}")
  ResponseEntity<PaymentDetails> findById(@PathVariable("paymentId") Long id) {
    Optional<PaymentEntity> optData = service.findById(id);
    return optData
        .map(pay -> ResponseEntity.ok(PaymentMapper.toDto(pay)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}

//  Notas:
//  PaymentDetails old_findById(@PathVariable("paymentId") Long id) {
//    return PaymentMapper.toDto(service.findById(id));
//  }
