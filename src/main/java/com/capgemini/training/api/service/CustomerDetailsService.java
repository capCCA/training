package com.capgemini.training.api.service;

import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {
  private final CustomerRepository userRepository;
  
  public List<CustomerEntity> findAll() {
    return userRepository.findAll();
  }

  public Optional<CustomerEntity> findById(String userId) {
    return userRepository.findById(userId);
  }

  public CustomerEntity findById_2(String userId) {
    return userRepository.findById(userId).orElse(null);
  }
}

// Motas
//  public CustomerEntity getReferenceById(String userId) {
//    return userRepository.getReferenceById(userId);
//  }
