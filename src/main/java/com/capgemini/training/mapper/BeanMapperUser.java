package com.capgemini.training.mapper;

import org.springframework.stereotype.Component;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.model.UserDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BeanMapperUser {

    public UserDto converterDto(UserEntity userEntity) {

        UserDto userDto = new UserDto();

        userDto.setCustomerId(userEntity.getCustomer_id());
        userDto.setDocumentType(userEntity.getDocument_type());
        userDto.setDocumentNumber(userEntity.getDocument_number());
        userDto.setName(userEntity.getName());
        userDto.setSurName(userEntity.getSurName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setCountry(userEntity.getCountry());
        userDto.setTelephone(userEntity.getTelephone());

        return userDto;
    }

    public UserEntity converterToEntity(UserDto userDto) {

        UserEntity userEntity = new UserEntity();

        userEntity.setCustomer_id(userDto.getCustomerId());
        userEntity.setDocument_type(userDto.getDocumentType());
        userEntity.setDocument_number(userDto.getDocumentNumber());
        userEntity.setName(userDto.getName());
        userEntity.setSurName(userDto.getSurName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setCountry(userDto.getCountry());
        userEntity.setTelephone(userDto.getTelephone());

        return userEntity;
    }

    public void mapToEntity(UserDto userDto, UserEntity userEntity) {

        userEntity.setDocument_type(userDto.getDocumentType());
        userEntity.setDocument_number(userDto.getDocumentNumber());
        userEntity.setName(userDto.getName());
        userEntity.setSurName(userDto.getSurName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setCountry(userDto.getCountry());
        userEntity.setTelephone(userDto.getTelephone());

    }

    /*
     * public static UserEntity toEntity(UserDto userDTO) { return
     * UserEntity.builder().customer_id(userDTO.getCustomerId())
     * .documentType(userDTO.getDocumentType().getValue()).documentNumber(userDTO.
     * getDocumentNumber())
     * .name(userDTO.getName()).surname(userDTO.getSurname()).lastname(userDTO.
     * getLastname())
     * .country(userDTO.getCountry()).telephone(userDTO.getTelephone()).build(); }
     */

}
