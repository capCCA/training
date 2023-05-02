package com.caggemini.training.user.controller;

import com.caggemini.training.user.entity.User;
import com.caggemini.training.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO- DTO

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserGetController {

    public final UserService userService;

    /**
     * method that pings the Controller
     * 
     * @return
     */
    @GetMapping(path = "/ping")
    public String pingMe() {
        try {
            return "..UserGetController..";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Method that returns all Users
     * 
     * @return {@link List} of {@link User}
     */
    @GetMapping(path = "")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
