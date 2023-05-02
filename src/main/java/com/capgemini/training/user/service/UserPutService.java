package com.capgemini.training.user.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserPutService {
    private final UserJpaRepository userRepository;

    // put
    public void update(Long id, UserDto dto) throws Exception {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user = dto.toUser(user);
            userRepository.save(user);
        } else {
            throw new Exception("Not found id " + id);
        }
    }

}
