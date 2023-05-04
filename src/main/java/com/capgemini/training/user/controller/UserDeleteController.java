package com.capgemini.training.user.controller;

import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.user.service.UserDeleteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserDeleteController {

    public final UserDeleteService userService;

    /**
     * Method that delete a User
     * 
     * @param id  PK of the entity
     * @param dto datos de la entidad
     */
//    @DeleteMapping(path = "/{userId}")
//    public void delete(@PathVariable(name = "userId")@NotBlank String userId) throws Exception {
//        userService.delete(userId);
//    }
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<String> delete(@PathVariable(name = "userId") @NotBlank String userId) throws Exception {
        userService.delete(userId);

        return ResponseEntity.ok().build();
    }
}
