package com.capgemini.training.controller;

import com.capgemini.training.models.Customer;
import com.capgemini.training.services.user.UserDeleteService;
import com.capgemini.training.services.user.UserEditService;
import com.capgemini.training.services.user.UserGetByIdService;
import com.capgemini.training.services.user.UserSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    //Lombok injection
    private final UserGetByIdService userGetByIdService;
    private final UserSaveService userSaveService;
    private final UserEditService userEditService;
    private final UserDeleteService userDeleteService;



    @GetMapping("/{customerId}")
    public Customer getUser( @PathVariable Long customerId ){

        return userGetByIdService.getUserById(customerId);

    }
    @PostMapping("/save")
    public Customer saveUser(@RequestBody Customer customer ){

        return userSaveService.saveUser(customer);

    }
    @PutMapping("/edit")
    public Customer updateUser(@RequestBody Customer customer ){

        return userEditService.editUser(customer);

    }
    @DeleteMapping("/remove/{customerId}")
    public void deleteUser(@PathVariable Long customerId ){

        userDeleteService.deleteUser(customerId);

    }
}
