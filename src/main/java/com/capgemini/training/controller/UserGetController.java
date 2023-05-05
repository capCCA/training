package com.capgemini.training.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.config.UserMapper;
import com.capgemini.training.dto.UserDto;
import com.capgemini.training.entity.User;
import com.capgemini.training.service.UserGetService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserGetController {

    public final UserGetService userService;
    // public final DozerBeanMapper mapper; // Alternative

    /**
     * method that pings the Controller
     * 
     * @return
     */
    @GetMapping(path = "/ping")
    public String pingMe() {
        try {
            return "ping UserGetController";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Method that returns all Users
     * 
     * @return {@link List} of {@link User}
     */
    @GetMapping(path = "")
    public List<UserDto> findAll() {
        List<User> users = userService.findAll();

        // Alternative using DozerBeanMapper
        // return users.stream().
        // map(u -> mapper.map(u,UserDto.class)).collect(Collectors.toList());
        return users.stream().map(UserMapper::toDto).collect(Collectors.toList());

    }

    /**
     * Method that returns a User
     * 
     * @return {@link User}
     */
    @GetMapping(path = "/{userId}")
    public UserDto findById(@PathVariable(name = "userId") @NotBlank String userId) {

        return UserMapper.toDto(userService.findById(userId));
    }

}
