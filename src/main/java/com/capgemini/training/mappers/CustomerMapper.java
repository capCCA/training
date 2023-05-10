package com.capgemini.training.mappers;

import com.capgemini.training.models.CustomerDetails;
import com.capgemini.training.models.DocumentType;
import com.capgemini.training.repositories.models.CustomerEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerMapper {

  public CustomerEntity toEntity(CustomerDetails customerDetails) {
    return CustomerEntity.builder()
        .customerId(customerDetails.getCustomerId())
        .documentType(customerDetails.getDocumentType().getValue())
        .documentNumber(customerDetails.getDocumentNumber())
        .name(customerDetails.getName())
        .surname(customerDetails.getSurname())
        .lastname(customerDetails.getLastname())
        .country(customerDetails.getCountry())
        .telephone(customerDetails.getTelephone())
        .build();
  }

  public CustomerDetails toDTO(CustomerEntity customer) {
    return CustomerDetails.builder()
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
