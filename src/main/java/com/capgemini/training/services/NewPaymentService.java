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
import com.capgemini.training.repositories.models.BeneficiaryEntity;
import com.capgemini.training.repositories.models.CustomerEntity;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewPaymentService {

  private final PaymentRepository paymentRepository;
  private final CustomerRepository customerRepository;
  private final BeneficiaryRepository beneficiaryRepository;

  public PaymentResponse addPayment(PaymentRequest paymentRequest) {
    if (paymentRequest.getPaymentId() == null
        || !paymentRepository.existsById(paymentRequest.getPaymentId())) {
      paymentRequest.setCreationDate(LocalDateTime.now());
      return PaymentMapper.entityToResponse(
          paymentRepository.save(
              PaymentMapper.requestToEntity(
                  paymentRequest,
                  findCustomerById(paymentRequest.getCustomerId()),
                  findBeneficiaryById(paymentRequest.getBeneficiaryId()))));
    }
    throw new PaymentBadRequestException("Already exists this payment id");
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
