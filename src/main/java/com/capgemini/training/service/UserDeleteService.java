package com.capgemini.training.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.UserEntity;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author ccsw
 *
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserDeleteService {

    private final UserRepository userRepository;

    public void delete(String customerId) {

        UserEntity entity = null;

        if (customerId != null) {
            entity = this.userRepository.getReferenceById(customerId);
        }

        if (entity != null) {
            this.userRepository.delete(entity);
        }
    }

}