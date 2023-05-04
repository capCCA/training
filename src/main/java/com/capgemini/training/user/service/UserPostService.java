package com.capgemini.training.user.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserPostService {
    private final UserJpaRepository userRepository;

    public UserDto save(UserDto dto) {
        dto.setCreationDate(new Date());
        User user = dto.toUser();
        return userRepository.save(user).toDto();
    }
}
