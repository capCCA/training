package com.capgemini.training.user.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserPutService {
    private final UserJpaRepository userRepository;

    public UserDto update(String id, UserDto dto) throws Exception {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            dto.setUpdateDate(new Date());
            user = dto.toUser(user);
            return userRepository.save(user).toDto();
        } else {
            throw new Exception("Not found id " + id);
        }
    }

}
