package com.capgemini.training.services;

import com.capgemini.training.converters.CustomerConverter;
import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.exceptions.CustomerBadRequestException;
import com.capgemini.training.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddCustomerService {

  private final CustomerRepository repository;
  private final CustomerConverter converter;

  public CustomerDTO addCustomer(CustomerDTO customerDTO) {
    customerDTO.setCreationDate(new Date());
    CustomerEntity customer = converter.toEntity(customerDTO);
    if (repository.existsById(customer.getCustomerId())) {
      throw new CustomerBadRequestException("This id already exists in the database");
    }
    return converter.toDTO(repository.save(customer));
  }
}
