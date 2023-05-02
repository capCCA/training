package com.capgemini.training.user.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserPostService {
    private final UserJpaRepository userRepository;

    // post
    public void save(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user = dto.toUser(user);
        userRepository.save(user);
    }

}
