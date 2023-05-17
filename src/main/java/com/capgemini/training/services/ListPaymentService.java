package com.capgemini.training.services;

import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.repositories.PaymentRepository;
import com.capgemini.training.repositories.models.PaymentEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListPaymentService {

  private final PaymentRepository paymentRepository;

  public List<PaymentResponse> getAllPaymentsByCustomerId(String customerId) {
    return paymentRepository.findAllByCustomerCustomerId(customerId).stream()
        .map(PaymentMapper::entityToResponse)
        .toList();
  }

  public List<PaymentResponse> getAllPayments() {
    return paymentRepository.findAll().stream().map(PaymentMapper::entityToResponse).toList();
  }
}
