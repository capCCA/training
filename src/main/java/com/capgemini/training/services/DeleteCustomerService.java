package com.capgemini.training.services;

import com.capgemini.training.exceptions.CustomerNotFoundException;
import com.capgemini.training.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerService {

  private final CustomerRepository repository;

  public void deleteCustomer(String id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    } else {
      throw new CustomerNotFoundException();
    }
  }
}
