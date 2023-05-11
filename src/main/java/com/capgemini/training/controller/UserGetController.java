package com.capgemini.training.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.exceptions.UserNotFoundException;
import com.capgemini.training.model.UserDto;
import com.capgemini.training.service.GetUserService;

import lombok.RequiredArgsConstructor;

/**
 * @author ezm
 * @description Controller to query User
 *
 */

@RequestMapping(value = "/user")
@RestController
@RequiredArgsConstructor
public class UserGetController {

    private final GetUserService userService;

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<UserDto> get(@PathVariable("customerId") String customerId) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.userService.get(customerId));

        } catch (UserNotFoundException e) {
            return ResponseEntity.noContent().build();

        }
    }

}