package com.capgemini.training.services;

import com.capgemini.training.errors.exceptions.BeneficiaryNotFoundException;
import com.capgemini.training.errors.exceptions.CustomerNotFoundException;
import com.capgemini.training.errors.exceptions.PaymentBadRequestException;
import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentRequest;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.repositories.BeneficiaryRepository;
import com.capgemini.training.repositories.CustomerRepository;
import com.capgemini.training.repositories.PaymentRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewPaymentService {

  private final PaymentRepository paymentRepository;
  private final CustomerRepository customerRepository;
  private final BeneficiaryRepository beneficiaryRepository;
  private final PaymentMapper paymentMapper;

  public PaymentResponse addPayment(PaymentRequest paymentRequest) {
    if (paymentRequest.getPaymentId() == null
        || !paymentRepository.existsById(paymentRequest.getPaymentId())) {
      paymentRequest.setCreationDate(LocalDateTime.now());
      return paymentMapper.entityToResponse(
          paymentRepository.save(
              paymentMapper.requestToEntity(
                  paymentRequest,
                  customerRepository
                      .findById(paymentRequest.getCustomerId())
                      .orElseThrow(CustomerNotFoundException::new),
                  beneficiaryRepository
                      .findById(paymentRequest.getBeneficiaryId())
                      .orElseThrow(BeneficiaryNotFoundException::new))));
    }
    throw new PaymentBadRequestException("Already exists this payment id");
  }
}
