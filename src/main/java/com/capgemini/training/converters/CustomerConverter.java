package com.capgemini.training.converters;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.models.CustomerEntity;
import com.capgemini.training.models.DocumentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerConverter {

  public CustomerEntity toEntity(CustomerDTO customerDTO) {
    return CustomerEntity.builder()
        .customerId(customerDTO.getCustomerId())
        .documentType(customerDTO.getDocumentType().getValue())
        .documentNumber(customerDTO.getDocumentNumber())
        .name(customerDTO.getName())
        .surname(customerDTO.getSurname())
        .lastname(customerDTO.getLastname())
        .country(customerDTO.getCountry())
        .telephone(customerDTO.getTelephone())
        .creationDate(customerDTO.getCreationDate())
        .updateDate(customerDTO.getUpdateDate())
        .build();
  }

  public CustomerDTO toDTO(CustomerEntity customer) {
    return CustomerDTO.builder()
        .customerId(customer.getCustomerId())
        .documentType(DocumentType.valueOf(customer.getDocumentType().toUpperCase()))
        .documentNumber(customer.getDocumentNumber())
        .name(customer.getName())
        .surname(customer.getSurname())
        .lastname(customer.getLastname())
        .country(customer.getCountry())
        .telephone(customer.getTelephone())
        .creationDate(customer.getCreationDate())
        .updateDate(customer.getUpdateDate())
        .build();
  }
}
