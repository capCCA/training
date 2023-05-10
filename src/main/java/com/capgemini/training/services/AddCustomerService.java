package com.capgemini.training.services;

import com.capgemini.training.models.CustomerDetails;
import com.capgemini.training.errors.CustomerBadRequestException;
import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.repositories.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddCustomerService {

  private final CustomerRepository repository;

  public CustomerDetails addCustomer(CustomerDetails customerDetails) {
    CustomerEntity customer = CustomerMapper.toEntity(customerDetails);
    if (repository.existsById(customer.getCustomerId())) {
      throw new CustomerBadRequestException("This id already exists in the database");
    }
    customer.setCreationDate(LocalDateTime.now());
    return CustomerMapper.toDTO(repository.save(customer));
  }
}
