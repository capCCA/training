package com.capgemini.training.services;

import com.capgemini.training.converters.CustomerConverter;
import com.capgemini.training.dtos.CustomerDTO;
import com.capgemini.training.exceptions.CustomerNotFoundException;
import com.capgemini.training.models.CustomerEntity;
import com.capgemini.training.repositories.CustomerRepository;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCustomerService {

  private final CustomerRepository repository;
  private final CustomerConverter converter;

  public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
    customerDTO.setUpdateDate(new Date());
    CustomerEntity customer = converter.toEntity(customerDTO);
    if (repository.existsById(customer.getCustomerId())) {
      return converter.toDTO(repository.save(customer));
    }
    throw new CustomerNotFoundException();
  }
}
