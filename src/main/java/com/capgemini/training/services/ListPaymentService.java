package com.capgemini.training.services;

import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.repositories.BeneficiaryRepository;
import com.capgemini.training.repositories.CustomerRepository;
import com.capgemini.training.repositories.PaymentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListPaymentService {

  private PaymentRepository paymentRepository;
  private CustomerRepository customerRepository;
  private BeneficiaryRepository beneficiaryRepository;
  private PaymentMapper paymentMapper;

  public List<PaymentResponse> getAllPaymentsByCustomerId(String customerId) {
    return paymentMapper.toResponseList(paymentRepository.findAll());
  }
}
