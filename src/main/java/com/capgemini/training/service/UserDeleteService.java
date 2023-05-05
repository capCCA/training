package com.capgemini.training.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserDeleteService {
    private final UserRepository userRepository;

    // delete
    public void delete(String id) throws Exception {
        if (userRepository.findById(id).orElse(null) == null) {
            throw new Exception("Not found id " + id);
        }
        userRepository.deleteById(id);
    }

}
