package com.capgemini.training.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.mapper.BeanMapperUser;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author ccsw
 *
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserGetService {

    private final UserRepository userRepository;
    private final BeanMapperUser beanMapperUser;

    public UserDto get(String customerId) {

        UserEntity entity = this.userRepository.getReferenceById(customerId);

        return this.beanMapperUser.converterDto(entity);
    }

}