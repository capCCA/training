package com.capgemini.training.service;

import com.capgemini.training.config.CustomerMapper;
import com.capgemini.training.dto.CustomerDetails;
import com.capgemini.training.entity.CustomerEntity;
import com.capgemini.training.errors.CustomerBadRequestException;
import com.capgemini.training.repository.UserRepository;
import java.util.Date;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NewCustomerDetailsService {
  private final UserRepository userRepository;

  @Transactional
  public CustomerDetails save(CustomerDetails dto) throws CustomerBadRequestException {
    CustomerEntity user = CustomerMapper.toEntity(dto);
    if (userRepository.existsById(user.getCustomerId())) {
      throw new CustomerBadRequestException("This id already exists in the database");
    }
    user.setCreationDate(new Date());
    // get the savedUser
    user= userRepository.save(user);
    return CustomerMapper.toDto( user);
  }
}
