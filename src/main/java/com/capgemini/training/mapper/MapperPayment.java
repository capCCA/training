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
        //UserEntity user = MapperUser.converterToEntity(dto.getUserDto());
        //BeneficiaryEntity beneficiary = MapperBeneficiary.converterToEntity(dto.getBeneficiaryDto());

        return PaymentEntity.builder().paymentId(dto.getPaymentId())//.customer(user)//.beneficiary(beneficiary)
                .paymentType(dto.getPaymentType()).amount(dto.getAmount()).build();
    }

    public static PaymentDto converterDto(PaymentEntity paymentEntity) {

        BeneficiaryDto benefDto = MapperBeneficiary.converterDto(paymentEntity.getBeneficiary());
        UserDto userDto = MapperUser.converterDto(paymentEntity.getCustomer());

        return PaymentDto.builder()
                .paymentId(paymentEntity.getPaymentId())
                .userDto(userDto).beneficiaryDto(benefDto)
                .paymentType(paymentEntity.getPaymentType())
                .amount(paymentEntity.getAmount()).build();

    }

    public void mapToEntity(PaymentDto paymentDto, PaymentEntity paymentEntity) {

        BeneficiaryDto benefDto = MapperBeneficiary.converterDto(paymentEntity.getBeneficiary());
        UserDto userDto = MapperUser.converterDto(paymentEntity.getCustomer());

        //paymentEntity.setCustomer().setDocumentType(userDto.getDocumentType());
        /*paymentEntity.setDocumentNumber(userDto.getDocumentNumber());
        paymentEntity.setName(userDto.getName());
        paymentEntity.setSurName(userDto.getSurName());
        paymentEntity.setLastName(userDto.getLastName());
        paymentEntity.setCountry(userDto.getCountry());
        paymentEntity.setTelephone(userDto.getTelephone());*/

    }

}
