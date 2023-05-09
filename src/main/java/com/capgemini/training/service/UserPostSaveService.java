package com.capgemini.training.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.mapper.BeanMapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserPostSaveService {

    private final UserRepository customerRepository;
    private final BeanMapperUser beanMapperUser;

    public boolean saveUser(UserDto userDto) {

        if (userDto == null)
            return false;

        UserEntity userEntity = beanMapperUser.converterToEntity(userDto);
        // userEntity.setCreation_date(new Date());
        return (customerRepository.save(userEntity) != null);

    }

}