package com.capgemini.training.api.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.api.model.PaymentDetails;
import com.capgemini.training.api.repository.model.PaymentEntity;
import com.capgemini.training.api.service.PaymentDetailsService;
import com.capgemini.training.api.service.mapper.PaymentMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "PaymentEntity", description = "API of PaymentGetController")
@RestController
@RequestMapping(path = "/payments")
@RequiredArgsConstructor
@Transactional
public class PaymentDetailsController {

    public final PaymentDetailsService service;

    /*
     * /payments?customerId=111 : findByCustomerId /payments :findAll
     */

    @Operation(summary = "Find all payments by customerId", description = "Method that returns a List of Payments by customerId if provided or All payments if not provided.")
    @GetMapping() // compite con el anterior, solo 1 es posible, añadir required=false, y asi se
                  // puede hacer os bus
    public ResponseEntity<List<PaymentDetails>> findByCustomerId(
            @RequestParam(value = "customerId", required = false) String customerId) {
        if (customerId == null || customerId.isEmpty()) {
            return ResponseEntity.ok(service.findAll().stream().map(PaymentMapper::toDto).toList());
        }
        return ResponseEntity.ok(service.findByCustomerId(customerId).stream().map(PaymentMapper::toDto).toList());
    }

    @Operation(summary = "Find a payment by Id", description = "Method that returns a PaymentEntity for the given paymentdD")
    @GetMapping(path = "/{paymentId}")
    public ResponseEntity<PaymentDetails> findById(@PathVariable("paymentId") Long id) {
        Optional<PaymentEntity> optData = service.findById(id);
        return optData.map(pay -> ResponseEntity.ok(PaymentMapper.toDto(pay)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

//-------- Notas:

/*
 * @Operation(summary = "Find all ", description =
 * "Method that returns a List of Payments with status 200 OK")
 * 
 * @GetMapping() public ResponseEntity<List<PaymentDetails>> findAll() { return
 * ResponseEntity.ok(service.findAll().stream().map(PaymentMapper::toDto).toList
 * ()); }
 */

// RequestParam is Spring, error if not provided, unless required=false. Can
// send a list
// QueryParam is not Spring
/*

 */
