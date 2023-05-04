package com.capgemini.training.user.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.service.UserPostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserPostController {

    public final UserPostService userService;

    /**
     * Method that saves a new User: creates a user
     * 
     * @param {@link UserDto}
     */
    @PostMapping(path = "", consumes = { "application/json" })
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserDto dto) {
        return ResponseEntity.ok(userService.save(dto));
    }

}
