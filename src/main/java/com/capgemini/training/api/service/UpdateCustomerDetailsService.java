package com.capgemini.training.api.service;

import com.capgemini.training.api.exceptions.CustomerNotFoundException;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.repository.UserRepository;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.service.mapper.CustomerMapper;
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

    // same as below.
    //CustomerEntity user1 =
    //    userRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException());

    CustomerEntity user = userRepository.findById(id).orElseThrow(null);
    if (user == null) {
      throw new CustomerNotFoundException();
    }

    Date wasCreated = user.getCreationDate();
    user = CustomerMapper.toEntity(dto);
    // corregir Date estan null al no existir en DTO
    user.setCreationDate(wasCreated);
    user.setUpdateDate(new Date());
    
    // Aqui se  puede hacer un Mapper.toEntity( user,dto)
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
