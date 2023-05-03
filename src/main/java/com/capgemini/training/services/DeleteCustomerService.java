package com.capgemini.training.services;

import com.capgemini.training.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerService {

  private final CustomerRepository repository;

  public boolean deleteCustomer(String id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
