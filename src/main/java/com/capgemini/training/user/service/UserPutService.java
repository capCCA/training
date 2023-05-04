package com.capgemini.training.user.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RequiredArgsConstructor
@Log
@Service
public class UserPutService {
    private final UserJpaRepository userRepository;

    // put
    public void update(String id, UserDto dto) throws Exception {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            dto.setUpdateDate(new Date());
            user = dto.toUser(user);
            if (!id.equals(user.getCustomerId())) {
                user.setCustomerId(id);
                log.info("update: CustomerId " + id + " will not be updated if added to Body with id "
                        + dto.getCustomerId());
            }
            userRepository.save(user);
        } else {
            throw new Exception("Not found id " + id);
        }
    }

}
