package com.capgemini.training.mappers;

import com.capgemini.training.dto.CustomerDto;
import com.capgemini.training.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    private final CustomerDto customerDto;
    public CustomerDto customerConverterDto( Customer customer,String customMessage ){

        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setDocumentType(customer.getDocumentType());
        customerDto.setDocumentNumber(customer.getDocumentNumber());
        customerDto.setName(customer.getName());
        customerDto.setSurName(customer.getSurname());
        customerDto.setLastName(customer.getLastname());
        customerDto.setCountry(customer.getCountry());
        customerDto.setTelephone(customer.getTelephone());
        customerDto.setCreationDate(customer.getCreationDate());
        customerDto.setUpdateDate(customer.getUpdateDate());
        //For setting a responseEntity custom message
        customerDto.setCustomMessage(customMessage);

        return customerDto;
    }

    public List<CustomerDto> customerConverterDto( List<Customer> customer ){

        return customer.stream().map( c -> customerConverterDto( c ,"")).collect(Collectors.toList());

    }
}
