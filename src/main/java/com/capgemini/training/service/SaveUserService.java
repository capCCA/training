package com.capgemini.training.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.exceptions.UserBadRequestException;
import com.capgemini.training.mapper.MapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveUserService {

    private final UserRepository customerRepository;

    public UserDto saveUser(UserDto userDto) {

        UserEntity userEntity = MapperUser.converterToEntity(userDto);

        if (customerRepository.existsById(userDto.getCustomerId())) {
            throw new UserBadRequestException("This idCustomer exits");
        }

        return MapperUser.converterDto(customerRepository.save(userEntity));

    }

}