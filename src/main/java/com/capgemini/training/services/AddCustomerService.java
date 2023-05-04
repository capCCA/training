package com.capgemini.training.services;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.errors.CustomerBadRequestException;
import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddCustomerService {

  private final CustomerRepository repository;

  public CustomerDTO addCustomer(CustomerDTO customerDTO) {
    CustomerEntity customer = CustomerMapper.toEntity(customerDTO);
    if (repository.existsById(customer.getCustomerId())) {
      throw new CustomerBadRequestException("This id already exists in the database");
    }
    customer.setCreationDate(new Date());
    return CustomerMapper.toDTO(repository.save(customer));
  }
}
