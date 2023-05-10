package com.capgemini.training.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
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
public class DeleteUserService {

    private final UserRepository userRepository;

    public void delete(String customerId) {

        Optional<UserEntity> entity = null;

        if (customerId != null) {
            entity = userRepository.findById(customerId);
        }
        if (entity.isEmpty()) {
            throw new EntityNotFoundException();
        }

        if (entity.isPresent()) {
            this.userRepository.deleteById(customerId);
        }
    }

}