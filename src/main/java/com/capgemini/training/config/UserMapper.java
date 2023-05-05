package com.capgemini.training.config;

import com.capgemini.training.dto.UserDto;
import com.capgemini.training.entity.User;

public final class UserMapper {

    public static User toEntity(UserDto dto) {
        return User.builder().customerId(dto.getCustomerId()).documentType(dto.getDocumentType())
                .documentNumber(dto.getDocumentNumber()).name(dto.getName()).surname(dto.getSurname())
                .lastname(dto.getLastname()).country(dto.getCountry()).telephone(dto.getTelephone()).build();
    }

    public static UserDto toDto(User user) {
        return UserDto.builder().customerId(user.getCustomerId()).documentType(user.getDocumentType())
                .documentNumber(user.getDocumentNumber()).name(user.getName()).surname(user.getSurname())
                .lastname(user.getLastname()).country(user.getCountry()).telephone(user.getTelephone()).build();
    }
}