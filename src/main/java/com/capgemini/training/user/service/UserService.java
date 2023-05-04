package com.capgemini.training.user.service;

import java.util.List;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

//@Service
public class UserService {
    private final UserJpaRepository userRepository;

    // get
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String userId) {
        return userRepository.getReferenceById(userId);
    }

    // Put: is idenpotent: Could be used for both, save or Update
    public void saveOrUpdate(String id, UserDto dto) {
        User user;
        if (id == null) {
            user = new User();
        } else {
            user = userRepository.getReferenceById(id);
        }
        user = dto.toUser(user);
        userRepository.save(user);

    }

    // post
    public void save(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user = dto.toUser(user);
        userRepository.save(user);
    }

    // put
    public void update(String id, UserDto dto) throws Exception {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            // user = mapper.map(dto, User.class);
            user = dto.toUser(user);
            userRepository.save(user);
        } else {
            throw new Exception("Not found id " + id);
        }
    }

    // delete
    public void delete(String id) throws Exception {
        if (userRepository.findById(id).orElse(null) == null) {
            throw new Exception("Not found id " + id);
        }
        userRepository.deleteById(id);
    }

}
