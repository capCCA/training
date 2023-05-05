package com.capgemini.training.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.capgemini.training.config.UserMapper;
import com.capgemini.training.dto.UserDto;
import com.capgemini.training.entity.User;
import com.capgemini.training.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RequiredArgsConstructor
@Log
@Service
public class UserPutService {
    private final UserRepository userRepository;

    public void update(String id, UserDto dto) throws Exception {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            Date wasCreated = user.getCreationDate();
            user = UserMapper.toEntity(dto);
            // corregir Date estan null al no existir en DTO
            user.setCreationDate(wasCreated);
            user.setUpdateDate(new Date());

            // corregir CustomerId - si se hubiera cambiado por estar en el Body y ser
            // distinto
            if (!id.equals(user.getCustomerId())) {
                user.setCustomerId(id);
                log.info("update CustomerId " + id + ": Body contains customerId:" + dto.getCustomerId()
                        + ", which is ignored.You can delete and create a new customer.");
            }
            userRepository.save(user);
        } else {
            throw new Exception("Not found id " + id);
        }
    }

}
