package com.capgemini.training.user.service;

import java.util.List;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.repository.UserCrudRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

//@Service
public class UserCrudService {
    private final UserCrudRepository userRepository;

    // get
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);

    }

    // Put: is idenpotent: Could be used for both, save or Update
    public void saveOrUpdate(Long id, UserDto dto) {
        User user;
        if (id == null) {
            user = new User();
        } else {
            user = userRepository.findById(id).orElse(null);
        }

        user = dto.toUser(user);
        userRepository.save(user);
    }

    // post
    public void save(UserDto dto) {
        User user = new User();
        user = dto.toUser(user);
        userRepository.save(user);
    }

    // put
    public void update(Long id, UserDto dto) throws Exception {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setName(user.getName());
            user = dto.toUser(user);
            userRepository.save(user);
        } else {
            throw new Exception("Not found id " + id);
        }
    }

    // delete
    public void delete(Long id) throws Exception {
        if (userRepository.findById(id).orElse(null) == null) {
            throw new Exception("Not found id " + id);
        }
        userRepository.deleteById(id);
    }

}
