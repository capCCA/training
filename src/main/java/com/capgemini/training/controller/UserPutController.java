package com.capgemini.training.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.model.UserDto;
import com.capgemini.training.service.UserPutUpdateService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class UserPutController {

    public final UserPutUpdateService userPutUpdateService;

    /**
     * Method that updates a User
     * 
     * @param userId
     * @param {@link UserDto}
     */
    @PutMapping(path = "/{customerId}")
    public ResponseEntity<UserDto> update(@PathVariable(name = "customerId") String customerId,
            @RequestBody UserDto dto) throws Exception {

        return ResponseEntity.ok(userPutUpdateService.update(customerId, dto));
    }
}