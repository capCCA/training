package com.capgemini.training.api.service.mapper;

import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.model.CustomerRequest;
import com.capgemini.training.api.repository.model.CustomerEntity;
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

    //sin customerId
    public static void updateEntityFromRequest(
            CustomerEntity entity, CustomerRequest customerDetails) {
        entity.setDocumentType(customerDetails.getDocumentType());
        entity.setDocumentNumber(customerDetails.getDocumentNumber());
        entity.setName(customerDetails.getName());
        entity.setSurname(customerDetails.getSurname());
        entity.setLastname(customerDetails.getLastname());
        entity.setCountry(customerDetails.getCountry());
        entity.setTelephone(customerDetails.getTelephone());
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
