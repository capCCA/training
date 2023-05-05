package com.capgemini.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.User;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserGetService {
    private final UserRepository userRepository;

    // get
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String userId) {
        return userRepository.getReferenceById(userId);
    }

}
