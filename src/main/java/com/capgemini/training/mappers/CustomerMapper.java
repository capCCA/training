package com.capgemini.training.mappers;

import com.capgemini.training.dto.CustomerDto;
import com.capgemini.training.dto.DocumentTypeEnum;
import com.capgemini.training.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    private final CustomerDto customerDto;
    private final Customer customer;
    public CustomerDto customerConverterDto( Customer customer,String customMessage ){

        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .country(customer.getCountry())
                .name(customer.getName())
                .surname(customer.getSurname())
                .telephone(customer.getTelephone())
                .lastname(customer.getLastname())
                .documentNumber(customer.getDocumentNumber())
                .documentType(DocumentTypeEnum.valueOf(customer.getDocumentType()))
                .creationDate(customer.getCreationDate())
                .updateDate(customer.getUpdateDate()).build();

    }

    public List<CustomerDto> customerConverterDto( List<Customer> customer ){

        return customer.stream().map( c -> customerConverterDto( c ,"")).collect(Collectors.toList());

    }

    public Customer requestConvertEntity(CustomerDto customerDto ){

        return Customer.builder()
                .customerId(customerDto.getCustomerId())
                .name(customerDto.getName())
                .telephone(customerDto.getTelephone())
                .country(customerDto.getCountry())
                .documentNumber(customerDto.getDocumentNumber())
                .documentType(String.valueOf(customerDto.getDocumentType()))
                .surname(customerDto.getSurname())
                .lastname(customerDto.getLastname())
                .creationDate(customerDto.getCreationDate())
                .updateDate(customerDto.getUpdateDate())
                .build();
    }
}
