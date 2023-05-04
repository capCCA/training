package com.capgemini.training.user.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.user.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserDeleteService {
    private final UserJpaRepository userRepository;

    // delete
    public void delete(String id) throws Exception {
        if (userRepository.findById(id).orElse(null) == null) {
            throw new Exception("Not found id " + id);
        }
        userRepository.deleteById(id);
    }

}
