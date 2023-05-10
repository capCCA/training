package com.capgemini.training.mapper;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.model.UserDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class MapperUser {

    public static UserEntity converterToEntity(UserDto userDto) {
        return UserEntity.builder().customerId(userDto.getCustomerId()).documentType(userDto.getDocumentType())
                .documentNumber(userDto.getDocumentNumber()).name(userDto.getName()).surName(userDto.getSurName())
                .lastName(userDto.getLastName()).country(userDto.getCountry()).telephone(userDto.getTelephone())
                .build();
    }

    public static UserDto converterDto(UserEntity userEntity) {
        return UserDto.builder().customerId(userEntity.getCustomerId()).documentType(userEntity.getDocumentType())
                .documentNumber(userEntity.getDocumentNumber()).name(userEntity.getName())
                .surName(userEntity.getSurName()).lastName(userEntity.getLastName()).country(userEntity.getCountry())
                .telephone(userEntity.getTelephone()).build();
    }

    /*
     * public static UserDto converterDto(UserEntity userEntity) {
     * 
     * UserDto userDto = new UserDto();
     * 
     * userDto.setCustomerId(userEntity.getCustomerId());
     * userDto.setDocumentType(userEntity.getDocumentType());
     * userDto.setDocumentNumber(userEntity.getDocumentNumber());
     * userDto.setName(userEntity.getName());
     * userDto.setSurName(userEntity.getSurName());
     * userDto.setLastName(userEntity.getLastName());
     * userDto.setCountry(userEntity.getCountry());
     * userDto.setTelephone(userEntity.getTelephone());
     * 
     * return userDto; }
     */

    /*
     * public static UserEntity converterToEntity(UserDto userDto) {
     * 
     * UserEntity userEntity = new UserEntity();
     * 
     * userEntity.setCustomerId(userDto.getCustomerId());
     * userEntity.setDocumentType(userDto.getDocumentType());
     * userEntity.setDocumentNumber(userDto.getDocumentNumber());
     * userEntity.setName(userDto.getName());
     * userEntity.setSurName(userDto.getSurName());
     * userEntity.setLastName(userDto.getLastName());
     * userEntity.setCountry(userDto.getCountry());
     * userEntity.setTelephone(userDto.getTelephone());
     * 
     * return userEntity; }
     */

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
