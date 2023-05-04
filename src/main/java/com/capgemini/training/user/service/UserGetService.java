package com.capgemini.training.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.repository.UserRepository;

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
