package com.capgemini.training.mappers;

import com.capgemini.training.models.BeneficiaryResponse;
import com.capgemini.training.models.CustomerResponse;
import com.capgemini.training.models.PaymentRequest;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.repositories.models.BeneficiaryEntity;
import com.capgemini.training.repositories.models.CustomerEntity;
import com.capgemini.training.repositories.models.PaymentEntity;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public final class PaymentMapper {

  public static PaymentResponse entityToResponse(PaymentEntity paymentEntity) {
    return PaymentResponse.builder()
        .paymentId(paymentEntity.getPaymentId())
        .beneficiary(
            BeneficiaryResponse.builder()
                .beneficiaryId(paymentEntity.getBeneficiary().getBeneficiaryId())
                .build())
        .customer(
            CustomerResponse.builder()
                .customerId(paymentEntity.getCustomer().getCustomerId())
                .documentType(paymentEntity.getCustomer().getDocumentType())
                .documentNumber(paymentEntity.getCustomer().getDocumentNumber())
                .name(paymentEntity.getCustomer().getName())
                .surname(paymentEntity.getCustomer().getSurname())
                .country(paymentEntity.getCustomer().getCountry())
                .build())
        .account(paymentEntity.getAccount())
        .paymentType(paymentEntity.getPaymentType())
        .build();
  }

  public static List<PaymentResponse> entityToResponseList(List<PaymentEntity> paymentEntities) {
    return paymentEntities.stream().map(PaymentMapper::entityToResponse).toList();
  }

  public static PaymentEntity requestToEntity(
      PaymentRequest paymentRequest,
      CustomerEntity customerEntity,
      BeneficiaryEntity beneficiaryEntity) {
    return PaymentEntity.builder()
        .paymentId(paymentRequest.getPaymentId())
        .beneficiary(beneficiaryEntity)
        .customer(customerEntity)
        .paymentType(paymentRequest.getPaymentType())
        .account(paymentRequest.getAccount())
        .creationDate(paymentRequest.getCreationDate())
        .build();
  }
}
