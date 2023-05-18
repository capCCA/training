package com.capgemini.training.services;

import com.capgemini.training.exceptions.BeneficiaryDetailsException;
import com.capgemini.training.exceptions.CustomerDetailsException;
import com.capgemini.training.exceptions.PaymentDetailsException;
import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.repository.models.BeneficiaryEntity;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.repository.models.PaymentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePaymentDetailsService {

  private final PaymentRepository paymentRepository;
  private final CustomerRepository customerRepository;
  private final BeneficiaryRepository beneficiaryRepository;
  private final PaymentMapper paymentMapper;

  public PaymentDetailsResponse updatePayment(PaymentEntity paymentEntity) {

    if (doRegistersEsxistOnDataBase(paymentEntity)) {

      return paymentMapper.toPaymentDetailsResponse(
          paymentRepository.save( paymentEntity ));
    }
    throw new PaymentDetailsException("Fallo al crear pago");
  }

  public boolean doRegistersEsxistOnDataBase(PaymentEntity paymentEntity) {

    return paymentRepository.existsById(paymentEntity.getPaymentId())
            && customerRepository.existsById(paymentEntity.getCustomer().getCustomerId())
            && beneficiaryRepository.existsById(paymentEntity.getBeneficiary().getBeneficiaryId())
        ? true
        : false;
  }

  public BeneficiaryEntity getBeneficiaryDetails(String beneficiaryId) {

    return beneficiaryRepository
        .findById(beneficiaryId)
        .orElseThrow(() -> new BeneficiaryDetailsException("El ID de beneficiario no existe"));
  }

  public CustomerEntity getCustomerDetails(String customerId) {

    return customerRepository
        .findById(customerId)
        .orElseThrow(() -> new CustomerDetailsException("El ID de usuario no existe"));
  }

}
