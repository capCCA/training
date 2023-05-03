package com.capgemini.training.services;

import com.capgemini.training.converters.CustomerConverter;
import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.exceptions.CustomerNotFoundException;
import com.capgemini.training.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {

  private final CustomerRepository repository;
  private final CustomerConverter converter;

  public CustomerDTO getCustomerDetail(String id) {
    Optional<CustomerEntity> customer = repository.findById(id);
    if (customer.isEmpty()) {
      throw new CustomerNotFoundException();
    }
    return converter.toDTO(customer.get());
  }
}
