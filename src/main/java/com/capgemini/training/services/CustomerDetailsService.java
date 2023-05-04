package com.capgemini.training.services;

import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {
  private final CustomerRepository repository;

  public CustomerDTO getCustomerDetail(String id) {
    return repository
        .findById(id)
        .map(CustomerMapper::toDTO)
        .orElseThrow(CustomerNotFoundException::new);
  }
}
