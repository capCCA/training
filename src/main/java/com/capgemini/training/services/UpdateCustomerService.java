package com.capgemini.training.services;

import com.capgemini.training.models.Customer;
import com.capgemini.training.repositories.CustomerRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCustomerService {

  private final CustomerRepository repository;

  public Optional<Customer> updateCustomer(Customer customer) {
    return repository.existsById(customer.getCustomerId())
        ? Optional.of(repository.save(customer))
        : Optional.empty();
  }
}
