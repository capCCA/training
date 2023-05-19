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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdatePaymentDetailsService {

  private final PaymentRepository paymentRepository;
  private final CustomerRepository customerRepository;
  private final BeneficiaryRepository beneficiaryRepository;
  private final PaymentMapper paymentMapper;

  public PaymentDetailsResponse updatePayment(PaymentEntity paymentEntity) {

    if (doRegistersEsxistOnDataBase(paymentEntity)) {

      return Optional.of(
              paymentMapper.toPaymentDetailsResponse(paymentRepository.save(paymentEntity)))
          .orElseThrow(() -> new PaymentDetailsException("Fallo al intentar de actualizar el pago"));
    }
    throw new PaymentDetailsException("Algun detalle no se ha insertado correctamente");
  }

  public boolean doRegistersEsxistOnDataBase(PaymentEntity paymentEntity) {

    return paymentRepository.existsById(paymentEntity.getPaymentId())
            && customerRepository.existsById(paymentEntity.getCustomer().getCustomerId())
            && beneficiaryRepository.existsById(paymentEntity.getBeneficiary().getBeneficiaryId())
        ? true
        : false;
  }
}
