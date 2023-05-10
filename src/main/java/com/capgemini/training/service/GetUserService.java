package com.capgemini.training.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.mapper.MapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GetUserService {

    private final UserRepository userRepository;

    public UserDto get(String customerId) {

        UserEntity entity = this.userRepository.getReferenceById(customerId);

        return MapperUser.converterDto(entity);
    }

}