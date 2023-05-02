package com.capgemini.training.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.service.UserPutService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserPutController {

    public final UserPutService userService;

    /**
     * Method that updates a User
     * 
     * @param userId
     * @param {@link UserDto}
     */
    @PutMapping(path = "/{userId}", consumes = { "application/json" })
    public void update(@PathVariable(name = "userId") Long userId, @RequestBody UserDto dto) throws Exception {
        userService.update(userId, dto);
    }

}
