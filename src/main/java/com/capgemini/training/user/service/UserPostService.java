package com.capgemini.training.user.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.repository.UserJpaRepository;
import java.util.Date;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserPostService {
    private final UserJpaRepository userRepository;

    // post
    public void save(UserDto dto) {
        dto.setCreationDate( new Date());
        User user = dto.toUser(); 
        userRepository.save(user);
    }
}
