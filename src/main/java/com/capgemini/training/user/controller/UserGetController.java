package com.capgemini.training.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.service.UserGetService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserGetController {

    public final UserGetService userService;
    // public final DozerBeanMapper mapper; // Alternative

    /**
     * method that pings the Controller
     * 
     * @return
     */
    @GetMapping(path = "/ping")
    public String pingMe() {
        try {
            return "ping UserGetController";
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
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> dtos = userService.findAll().stream().map(u -> u.toDto()).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);

    }

    /**
     * Method that returns a Userdto
     * 
     * @return ResponseEntity <{@link User}>
     */
    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable(name = "userId") @NotBlank String userId) {
        return ResponseEntity.ok(userService.findById(userId).toDto());
    }

}
