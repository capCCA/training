package com.capgemini.training.controller.user;

import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.services.user.UserDeleteService;
import com.capgemini.training.services.user.UserSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserDelete {

    private final UserSaveService userSaveService;
    private final UserDeleteService userDeleteService;

    @DeleteMapping("/remove/{customerId}")
    public ResponseEntity<String> deleteUser(@PathVariable String customerId) {

        if ( userDeleteService.delete(customerId) ) {
            ResponseEntity.ok("El usuario con id " + customerId + " Ha sido eliminado correctamente");
        }
        return ResponseEntity.status(404)
                .body("El id de usuario" + customerId + " no se encuentra registrado");

    }
}
