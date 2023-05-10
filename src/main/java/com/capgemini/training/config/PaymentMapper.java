package com.capgemini.training.config;

import com.capgemini.training.dto.BeneficiaryDto;
import com.capgemini.training.dto.PaymentDto;
import com.capgemini.training.dto.UserDto;
import com.capgemini.training.entity.Beneficiary;
import com.capgemini.training.entity.Payment;
import com.capgemini.training.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentMapper {


  public Payment toEntity(PaymentDto dto) {
    User customer = UserMapper.toEntity( dto.getCustomerDto());
    Beneficiary ben = BeneficiaryMapper.toEntity (dto.getBeneficiaryDto());

    return Payment.builder()
            .paymentId(dto.getPaymentId())
            .customer ( customer)
            .beneficiary( ben)
            .paymentType(dto.getPaymentType())
            .amount(dto.getAmount())
            .build();
  }

  public PaymentDto toDto(Payment payment) {
    BeneficiaryDto benDto= BeneficiaryMapper.toDto( payment.getBeneficiary() );
    UserDto customerDto= UserMapper.toDto( payment.getCustomer());

    return PaymentDto.builder()
        .paymentId(payment.getPaymentId())
        .customerDto( customerDto)
        .beneficiaryDto(benDto)
        .paymentType(payment.getPaymentType())
        .amount(payment.getAmount())
        .build();
  }

  
}
