package com.capgemini.training.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.service.DeleteUserService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/user")
@RestController
@RequiredArgsConstructor
public class DeleteUserController {

    private final DeleteUserService userDeleteService;

    @DeleteMapping(path = "/{customerId}")
    public ResponseEntity<Void> delete(@PathVariable("customerId") String customerId) {
        try {

            this.userDeleteService.delete(customerId);
            return ResponseEntity.ok().build();

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
