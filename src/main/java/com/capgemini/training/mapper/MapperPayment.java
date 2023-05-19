package com.capgemini.training.mapper;

import com.capgemini.training.entity.BeneficiaryEntity;
import com.capgemini.training.entity.PaymentEntity;
import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.model.BeneficiaryDto;
import com.capgemini.training.model.PaymentDto;
import com.capgemini.training.model.UserDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class MapperPayment {

    public static PaymentEntity converterToEntity(PaymentDto dto) {
        UserEntity user = MapperUser.converterToEntity(dto.getUserDto());
        BeneficiaryEntity beneficiary = MapperBeneficiary.converterToEntity(dto.getBeneficiaryDto());

        return PaymentEntity.builder().paymentId(dto.getPaymentId()).customer(user).beneficiary(beneficiary)
                .paymentType(dto.getPaymentType()).amount(dto.getAmount()).build();


    }

    public static PaymentDto converterDto(PaymentEntity paymentEntity) {

        BeneficiaryDto benefDto = MapperBeneficiary.converterDto(paymentEntity.getBeneficiary());
        UserDto userDto = MapperUser.converterDto(paymentEntity.getCustomer());

        return PaymentDto.builder()
                .paymentId(paymentEntity.getPaymentId())
                //.customerId(paymentEntity.getCustomer().getCustomerId())
                //.beneficiaryId(paymentEntity.getBeneficiary().getBeneficiaryId())
                .userDto(userDto)
                .beneficiaryDto(benefDto)
                .paymentType(paymentEntity.getPaymentType())
                .amount(paymentEntity.getAmount()).build();

    }



    public static PaymentEntity mapToEntity(PaymentDto paymentDto, PaymentEntity paymentEntity) {

        BeneficiaryDto benefDto = MapperBeneficiary.converterDto(paymentEntity.getBeneficiary());
        UserDto userDto = MapperUser.converterDto(paymentEntity.getCustomer());

        paymentEntity.setCustomer(paymentEntity.getCustomer());
        paymentEntity.setBeneficiary(paymentEntity.getBeneficiary());
        paymentEntity.setPaymentType(paymentDto.getPaymentType());
        paymentEntity.setAmount(paymentDto.getAmount());

        return paymentEntity;
    }

}
