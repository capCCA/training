package com.capgemini.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.model.UserDto;
import com.capgemini.training.service.UserGetService;

import lombok.RequiredArgsConstructor;

/**
 * @author ezm
 *
 */

@RequestMapping(value = "/user")
@RestController
@RequiredArgsConstructor
public class UserGetController {

    private final UserGetService userService;

    // @RequestMapping(path = "", method = RequestMethod.GET)
    // @GetMapping(path = "/{customerId}")
    // http://localhost:8080/user/custom1
    @GetMapping(value = "/{customerId}")
    public UserDto get(@PathVariable("customerId") String customerId) {

        return this.userService.get(customerId);
    }

}