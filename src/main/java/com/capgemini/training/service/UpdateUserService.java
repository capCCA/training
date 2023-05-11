package com.capgemini.training.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.mapper.MapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author ezorzome
 * @descriprion Service to update User
 *
 */

@RequiredArgsConstructor
@Service
public class UpdateUserService {

    private final UserRepository userRepository;

    public UserDto update(String idCustomer, UserDto dto) {

        UserEntity userEntity = userRepository.findById(idCustomer)
                .orElseThrow(() -> new UserNotFoundException("User with ID :" + idCustomer + " Not Found!"));
        MapperUser.mapToEntity(dto, userEntity);
        userRepository.save(userEntity);

        return dto;

    }

}
