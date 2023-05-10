package com.capgemini.training.config;

import com.capgemini.training.dto.CustomerDetails;
import com.capgemini.training.entity.CustomerEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerMapper {

  public CustomerEntity toEntity(CustomerDetails dto) {
    return CustomerEntity.builder()
        .customerId(dto.getCustomerId())
        // .documentType(dto.getDocumentType().getValue())
        .documentType(dto.getDocumentType())
        .documentNumber(dto.getDocumentNumber())
        .name(dto.getName())
        .surname(dto.getSurname())
        .lastname(dto.getLastname())
        .country(dto.getCountry())
        .telephone(dto.getTelephone())
        .build();
  }

  public CustomerDetails toDto(CustomerEntity user) {
    return CustomerDetails.builder()
        .customerId(user.getCustomerId())
        // .documentType(DocumentType.valueOf(user.getDocumentType()))
        .documentType(user.getDocumentType())
        .documentNumber(user.getDocumentNumber())
        .name(user.getName())
        .surname(user.getSurname())
        .lastname(user.getLastname())
        .country(user.getCountry())
        .telephone(user.getTelephone())
        .build();
  }
}
