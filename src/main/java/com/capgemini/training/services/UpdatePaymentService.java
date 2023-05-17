package com.capgemini.training.services;

import com.capgemini.training.errors.exceptions.BeneficiaryNotFoundException;
import com.capgemini.training.errors.exceptions.CustomerNotFoundException;
import com.capgemini.training.errors.exceptions.PaymentNotFoundException;
import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentRequest;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.repositories.BeneficiaryRepository;
import com.capgemini.training.repositories.CustomerRepository;
import com.capgemini.training.repositories.PaymentRepository;
import com.capgemini.training.repositories.models.BeneficiaryEntity;
import com.capgemini.training.repositories.models.CustomerEntity;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePaymentService {
  private final PaymentRepository paymentRepository;
  private final CustomerRepository customerRepository;
  private final BeneficiaryRepository beneficiaryRepository;

  public PaymentResponse updatePayment(PaymentRequest paymentRequest) {
    if (paymentRepository.existsById(paymentRequest.getPaymentId())) {
      paymentRequest.setUpdateDate(LocalDateTime.now());
      return PaymentMapper.entityToResponse(
          paymentRepository.save(
              PaymentMapper.requestToEntity(
                  paymentRequest,
                  findCustomerById(paymentRequest.getCustomerId()),
                  findBeneficiaryById(paymentRequest.getBeneficiaryId()))));
    }
    throw new PaymentNotFoundException();
  }

  private CustomerEntity findCustomerById(String customerId) {
    return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
  }

  private BeneficiaryEntity findBeneficiaryById(String beneficiaryId) {
    return beneficiaryRepository
        .findById(beneficiaryId)
        .orElseThrow(BeneficiaryNotFoundException::new);
  }
}
