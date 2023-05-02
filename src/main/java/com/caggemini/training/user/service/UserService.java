package com.caggemini.training.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caggemini.training.user.entity.User;
import com.caggemini.training.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
