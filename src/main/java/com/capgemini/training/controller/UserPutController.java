package com.capgemini.training.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.model.UserDto;
import com.capgemini.training.service.UpdateUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class UserPutController {

    public final UpdateUserService userPutUpdateService;

    /**
     * Method that updates a User
     * 
     * @param userId
     * @param {@link UserDto}
     */
    @PutMapping(path = "/{customerId}")
    public ResponseEntity<UserDto> update(@Valid @PathVariable(name = "customerId") String customerId,
            @RequestBody UserDto dto) throws Exception {

        try {

            return ResponseEntity.ok(userPutUpdateService.update(customerId, dto));

        } catch (Exception e) {
            return ResponseEntity.noContent().build();

        }
    }
}