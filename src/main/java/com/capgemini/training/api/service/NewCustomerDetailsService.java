package com.capgemini.training.api.service;

import com.capgemini.training.api.exceptions.CustomerBadRequestException;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.repository.UserRepository;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.service.mapper.CustomerMapper;
import java.util.Date;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewCustomerDetailsService {
  private final UserRepository userRepository;

  @Transactional
  public CustomerDetails save(CustomerDetails dto) {
    CustomerEntity user = CustomerMapper.toEntity(dto);
    if (userRepository.existsById(user.getCustomerId())) {
      throw new CustomerBadRequestException("Error saving customer. This customerId already exists.");
    }
    user.setCreationDate(new Date());
    // get the savedUser
    user = userRepository.save(user);
    return CustomerMapper.toDto(user);
  }
}
