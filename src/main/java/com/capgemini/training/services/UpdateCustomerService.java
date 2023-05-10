package com.capgemini.training.services;

import com.capgemini.training.models.CustomerDetails;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.repositories.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCustomerService {
  private final CustomerRepository repository;

  public CustomerDetails updateCustomer(CustomerDetails customerDetails) {
    if (repository.existsById(customerDetails.getCustomerId())) {
      CustomerEntity customer = CustomerMapper.toEntity(customerDetails);
      customer.setUpdateDate(LocalDateTime.now());
      return CustomerMapper.toDTO(repository.save(customer));
    }
    throw new CustomerNotFoundException();
  }
}
