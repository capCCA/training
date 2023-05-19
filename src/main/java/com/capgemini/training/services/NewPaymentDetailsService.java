package com.capgemini.training.services;

import com.capgemini.training.exceptions.BeneficiaryDetailsException;
import com.capgemini.training.exceptions.CustomerDetailsException;
import com.capgemini.training.exceptions.PaymentDetailsException;
import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentDetailsRequest;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.repository.models.BeneficiaryEntity;
import com.capgemini.training.repository.models.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewPaymentDetailsService {

  private final PaymentRepository paymentRepository;
  private final CustomerRepository customerRepository;
  private final BeneficiaryRepository beneficiaryRepository;
  private final PaymentMapper paymentMapper;

  public PaymentDetailsResponse createNewPayment(PaymentDetailsRequest paymentDetailsRequest) {

    if (doRegistersExistOnDataBase(paymentDetailsRequest)) {

      return Optional.of(
              paymentMapper.toPaymentDetailsResponse(
                  paymentRepository.save(
                      paymentMapper.toEntityFromRequest(
                          paymentDetailsRequest,
                          getCustomerDetails(paymentDetailsRequest.getCustomerId()),
                          getBeneficiaryDetails(paymentDetailsRequest.getBeneficiaryId())))))
          .orElseThrow(() -> new PaymentDetailsException("Fallo al crear pago"));
    }
    throw new PaymentDetailsException("Algun detalle no se ha insertado correctamente");
  }

  public boolean doRegistersExistOnDataBase(PaymentDetailsRequest paymentDetailsRequest) {

    return customerRepository.existsById(paymentDetailsRequest.getCustomerId())
            && beneficiaryRepository.existsById(paymentDetailsRequest.getBeneficiaryId())
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
