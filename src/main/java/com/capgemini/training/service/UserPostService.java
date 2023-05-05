package com.capgemini.training.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.capgemini.training.config.UserMapper;
import com.capgemini.training.dto.UserDto;
import com.capgemini.training.entity.User;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserPostService {
    private final UserRepository userRepository;

    public void save(UserDto dto) {
        User user = UserMapper.toEntity(dto);
        user.setCreationDate(new Date());
        userRepository.save(user);
    }
}
