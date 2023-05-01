package com.capgemini.training.services;

import com.capgemini.training.models.Customer;
import com.capgemini.training.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddCustomerService {

  private final CustomerRepository repository;

  public Customer addCustomer(Customer customer) {
    return repository.save(customer);
  }
}
