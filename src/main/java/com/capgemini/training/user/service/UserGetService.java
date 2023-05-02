package com.capgemini.training.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserGetService {
    private final UserJpaRepository userRepository;

    // get
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long userId) {
        return userRepository.getReferenceById(userId);
    }

}
