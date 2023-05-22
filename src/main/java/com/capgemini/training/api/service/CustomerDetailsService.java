package com.capgemini.training.api.service;

import com.capgemini.training.api.exceptions.CustomerNotFoundException;
import com.capgemini.training.api.repository.CustomerRepository;
import com.capgemini.training.api.repository.model.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {
    private final CustomerRepository userRepository;

    public List<CustomerEntity> findAll() {
        return userRepository.findAll();
    }

    public CustomerEntity findById(String userId) {
        return userRepository.findById(userId).orElseThrow(CustomerNotFoundException::new);

    }

    public Optional<CustomerEntity> findById_old(String userId) {
        return userRepository.findById(userId);
    }

}

