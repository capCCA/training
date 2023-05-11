package com.capgemini.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.model.UserDto;
import com.capgemini.training.service.SaveUserService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author ezorzome {@summary: Controller to call save Service}
 */

@RequestMapping(value = "/user")
@RestController
@RequiredArgsConstructor
public class UserPostController {

    private final SaveUserService userSaveService;

    /**
     * Method to save Users (customers)
     *
     * @return {@link List} de {@link UserDto}
     * @throws Exception
     */

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody(required = true) UserDto userDto) {
        userSaveService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);

    }

}
