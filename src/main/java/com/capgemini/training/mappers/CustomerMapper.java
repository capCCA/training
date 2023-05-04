package com.capgemini.training.mappers;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.dtos.DocumentType;
import com.capgemini.training.models.CustomerEntity;

public final class CustomerMapper {

  public static CustomerEntity toEntity(CustomerDTO customerDTO) {
    return CustomerEntity.builder()
        .customerId(customerDTO.getCustomerId())
        .documentType(customerDTO.getDocumentType().getValue())
        .documentNumber(customerDTO.getDocumentNumber())
        .name(customerDTO.getName())
        .surname(customerDTO.getSurname())
        .lastname(customerDTO.getLastname())
        .country(customerDTO.getCountry())
        .telephone(customerDTO.getTelephone())
        .build();
  }

  public static CustomerDTO toDTO(CustomerEntity customer) {
    return CustomerDTO.builder()
        .customerId(customer.getCustomerId())
        .documentType(DocumentType.valueOf(customer.getDocumentType()))
        .documentNumber(customer.getDocumentNumber())
        .name(customer.getName())
        .surname(customer.getSurname())
        .lastname(customer.getLastname())
        .country(customer.getCountry())
        .telephone(customer.getTelephone())
        .build();
  }
}
