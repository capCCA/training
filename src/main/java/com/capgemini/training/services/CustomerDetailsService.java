package com.capgemini.training.services;

import com.capgemini.training.models.Customer;
import com.capgemini.training.repositories.CustomerRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {

  private final CustomerRepository repository;

  public Optional<Customer> getCustomerDetail(String id) {
    return repository.findById(id);
  }
}
