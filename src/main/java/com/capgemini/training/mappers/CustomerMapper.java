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
    private final Customer customer;
    public CustomerDto customerConverterDto( Customer customer,String customMessage ){

        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setDocumentType(customer.getDocumentType());
        customerDto.setDocumentNumber(customer.getDocumentNumber());
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setLastname(customer.getLastname());
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

    public Customer requestConvertEntity(CustomerDto customerDto ){

        customer.setCustomerId( customerDto.getCustomerId() );
        customer.setName( customerDto.getName() );
        customer.setTelephone( customerDto.getTelephone() );
        customer.setCountry( customerDto.getCountry() );
        customer.setDocumentNumber( customerDto.getDocumentNumber() );
        customer.setDocumentType( customerDto.getDocumentType() );
        customer.setLastname( customerDto.getLastname() );
        customer.setSurname( customerDto.getSurname() );
        customer.setCreationDate( customerDto.getCreationDate() );
        customer.setUpdateDate( customerDto.getUpdateDate() );

        return customer;
    }
}
