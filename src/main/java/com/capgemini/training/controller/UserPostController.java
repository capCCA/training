package com.capgemini.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.model.UserDto;
import com.capgemini.training.service.UserPostSaveService;

import lombok.RequiredArgsConstructor;

/**
 * @author ccsw
 *
 */
//@Tag(name = "User", description = "API of User")
@RequestMapping(value = "/user")
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserPostController {

    private final UserPostSaveService userSaveService;

    /**
     * Método para salvar Users (customers)
     *
     * @return {@link List} de {@link UserDto}
     * @throws Exception
     */

    @PostMapping
    public ResponseEntity<String> saveUser(@Valid @RequestBody UserDto userDto) throws Exception {

        // ResponseEntity, objeto q utiliza springboot para devolver cosas

        if (userSaveService.saveUser(userDto)) {
            // 200 valor generico, 201 es el de creacion, se ha creado
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario insertado correctamente");
        } else {
            throw new Exception("Error al tratar de crear Usuario");
        }

    }

}
