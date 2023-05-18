package com.capgemini.training.mapper;

import com.capgemini.training.entity.BeneficiaryEntity;
import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.model.BeneficiaryDto;
import com.capgemini.training.model.UserDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class MapperBeneficiary {

    public static BeneficiaryEntity converterToEntity(BeneficiaryDto dto) {
        return BeneficiaryEntity.builder().beneficiaryId(dto.getBeneficiaryId()).build();
    }

    public static BeneficiaryDto converterDto(BeneficiaryEntity entity) {
        return BeneficiaryDto.builder().beneficiaryId(entity.getBeneficiaryId()).build();
    }

    public void mapToEntity(UserDto userDto, UserEntity userEntity) {

        userEntity.setDocumentType(userDto.getDocumentType());
        userEntity.setDocumentNumber(userDto.getDocumentNumber());
        userEntity.setName(userDto.getName());
        userEntity.setSurName(userDto.getSurName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setCountry(userDto.getCountry());
        userEntity.setTelephone(userDto.getTelephone());

    }

}
