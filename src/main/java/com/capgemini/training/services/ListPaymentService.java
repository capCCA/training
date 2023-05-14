package com.capgemini.training.services;

import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.repositories.PaymentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service 
@RequiredArgsConstructor
public class ListPaymentService {

  private final PaymentRepository paymentRepository;
  public List<PaymentResponse> getAllPaymentsByCustomerId(String customerId) {
    return PaymentMapper.entityToResponseList(paymentRepository.findAllByCustomerCustomerId(customerId));
  }

  public List<PaymentResponse> getAllPayments(){
    return PaymentMapper.entityToResponseList(paymentRepository.findAll());
  }
}
