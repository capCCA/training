package com.capgemini.training.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.mapper.MapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
//@Transactional
@RequiredArgsConstructor
public class GetUserService {

    private final UserRepository userRepository;

    public UserDto get(String customerId) {

        return userRepository.findById(customerId).map(MapperUser::converterDto)
                .orElseThrow(() -> new UserNotFoundException("customer does not exist in database"));

        /*
         * Optional<UserEntity> entity = this.userRepository.findById(customerId);
         * 
         * if (entity.isEmpty()) { throw new EntityNotFoundException(); }
         * 
         * return MapperUser.converterDto(entity);
         */
    }

}