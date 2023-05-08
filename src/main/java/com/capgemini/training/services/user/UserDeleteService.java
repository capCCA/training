package com.capgemini.training.services.user;

import com.capgemini.training.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteService {

  // Repository injection
  private final CustomerRepository customerRepository;

  public boolean delete( String id ) {

    if( customerRepository.findById(id).isPresent() ){

      customerRepository.deleteById(id);
      return true;

    }
    return false;
  }
}
