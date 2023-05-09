package com.capgemini.training.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.mapper.BeanMapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserPutUpdateService {

    private final UserRepository userRepository;
    private final BeanMapperUser beanMapperUser;

    public UserDto update(String idCustomer, UserDto dto) {

        try {
            UserEntity userEntity = userRepository.findById(idCustomer).orElseThrow();// .orElse(null);
            beanMapperUser.mapToEntity(dto, userEntity);
            userRepository.save(userEntity);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return dto;

    }

}
