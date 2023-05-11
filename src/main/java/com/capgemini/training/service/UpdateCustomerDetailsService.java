package com.capgemini.training.service;

import com.capgemini.training.config.CustomerMapper;
import com.capgemini.training.dto.CustomerDetails;
import com.capgemini.training.entity.CustomerEntity;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.repository.UserRepository;
import java.util.Date;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log
@Service
public class UpdateCustomerDetailsService {
  private final UserRepository userRepository;

  @Transactional
  public CustomerDetails update(String id, CustomerDetails dto) {
    CustomerEntity user = userRepository.findById(id).orElse(null);
    if (user == null) {
      throw new CustomerNotFoundException();
    }

    Date wasCreated = user.getCreationDate();
    user = CustomerMapper.toEntity(dto);
    // corregir Date estan null al no existir en DTO
    user.setCreationDate(wasCreated);
    user.setUpdateDate(new Date());

    // corregir CustomerId - si se hubiera cambiado por estar en el Body y ser
    // distinto
    if (!id.equals(user.getCustomerId())) {
      user.setCustomerId(id);
      log.info(
          "update CustomerId "
              + id
              + ": Body contains customerId:"
              + dto.getCustomerId()
              + ", which is ignored.You can delete and create a new customer.");
    }
    return CustomerMapper.toDto(userRepository.save(user));
  }
}
