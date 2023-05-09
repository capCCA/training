package com.capgemini.training.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.service.UserDeleteService;

import lombok.RequiredArgsConstructor;

//import io.swagger.v3.oas.annotations.Operation;

/**
 * @author ccsw
 *
 */
//@Tag(name = "User", description = "API of User")
@RequestMapping(value = "/user")
@RestController
//@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserDeleteController {

    private final UserDeleteService userDeleteService;

    @DeleteMapping(path = "/{customerId}")
    public void delete(@PathVariable("customerId") String customerId) {

        this.userDeleteService.delete(customerId);
    }

}
