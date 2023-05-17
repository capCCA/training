package com.capgemini.training.mappers;

import com.capgemini.training.models.PaymentDetailsRequest;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.models.BeneficiaryEntity;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.repository.models.PaymentEntity;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentMapper {

  private final CustomerRepository customerRepository;
  private final BeneficiaryRepository beneficiaryRepository;

  public PaymentDetailsResponse toPaymentDetailsResponse(PaymentEntity paymentEntity) {

    return PaymentDetailsResponse.builder()
        .paymentId(paymentEntity.getPaymentId())
        .customer(paymentEntity.getCustomer())
        .beneficiary(paymentEntity.getBeneficiary())
        .paymentType(paymentEntity.getPaymentType())
        .amount(paymentEntity.getAmount())
        .creationDate(LocalDate.now())
        .updateDate(paymentEntity.getUpdateDate())
        .build();
  }

  public PaymentEntity toEntityFromRequest(
      PaymentDetailsRequest paymentDetailsRequest,
      CustomerEntity customerEntity,
      BeneficiaryEntity beneficiaryEntity) {

    return PaymentEntity.builder()
        .customer(customerEntity)
        .beneficiary(beneficiaryEntity)
        .paymentId(paymentDetailsRequest.getPaymentId())
        .paymentType(paymentDetailsRequest.getPaymentType())
        .amount(paymentDetailsRequest.getAmount())
        .creationDate(LocalDate.now())
        .updateDate(paymentDetailsRequest.getUpdateDate())
        .build();
  }
}
