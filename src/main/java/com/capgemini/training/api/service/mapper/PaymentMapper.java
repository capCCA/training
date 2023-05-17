package com.capgemini.training.api.service.mapper;

import com.capgemini.training.api.model.BeneficiaryDetails;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.model.PaymentDetails;
import com.capgemini.training.api.repository.model.BeneficiaryEntity;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.repository.model.PaymentEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentMapper {

  public PaymentEntity toEntity(PaymentDetails dto) {
    CustomerEntity customer = CustomerMapper.toEntity(dto.getCustomerDetails());
    BeneficiaryEntity ben = BeneficiaryMapper.toEntity(dto.getBeneficiaryDto());

    return PaymentEntity.builder()
        .paymentId(dto.getPaymentId())
        .customer(customer)
        .beneficiary(ben)
        // .paymentType(String.valueOf(dto.getPaymentType()))
        .paymentType(dto.getPaymentType())
        .amount(dto.getAmount())
        .build();
  }

  public PaymentDetails toDto(PaymentEntity payment) {
    BeneficiaryDetails benDto = BeneficiaryMapper.toDto(payment.getBeneficiary());
    CustomerDetails customerDetails = CustomerMapper.toDto(payment.getCustomer());

    return PaymentDetails.builder()
        .paymentId(payment.getPaymentId())
        .customerDetails(customerDetails)
        .beneficiaryDto(benDto)
        // .paymentType(PaymentType.valueOf(payment.getPaymentType()))
        .paymentType(payment.getPaymentType())
        .amount(payment.getAmount())
        .build();
  }
}
