package com.capgemini.training.service;

import com.capgemini.training.entity.User;
import com.capgemini.training.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserGetService {
  private final UserRepository userRepository;
  
  public List<User> findAll() {
    return userRepository.findAll();
  }

  public Optional<User> findById(String userId) {
    return userRepository.findById(userId);
  }


  public User findById_2(String userId) {
    return userRepository.findById(userId).orElse(null);
  }
}


// Motas
//  public User getReferenceById(String userId) {
//    return userRepository.getReferenceById(userId);
//  }

