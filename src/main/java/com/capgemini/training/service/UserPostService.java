package com.capgemini.training.service;

import com.capgemini.training.config.UserMapper;
import com.capgemini.training.dto.UserDto;
import com.capgemini.training.entity.User;
import com.capgemini.training.repository.UserRepository;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserPostService {
  private final UserRepository userRepository;

  public UserDto save(UserDto dto) {
    User user = UserMapper.toEntity(dto);
    user.setCreationDate(new Date());
    // get the savedUser
    user= userRepository.save(user);
    return UserMapper.toDto( user);
  }
}
