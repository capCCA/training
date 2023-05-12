package com.capgemini.training.controllers;

import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.repositories.PaymentRepository;
import com.capgemini.training.repositories.models.PaymentEntity;
import com.capgemini.training.services.ListPaymentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payment")
@RequiredArgsConstructor
public class ListPaymentsController {

    private final ListPaymentService listPaymentService;
    
    @GetMapping()
    public ResponseEntity<List<PaymentEntity>> getAllPaymentByCustomerId(){
        return ResponseEntity.ok().build();
    }
}
