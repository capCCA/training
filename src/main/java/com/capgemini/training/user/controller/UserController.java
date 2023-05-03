package com.capgemini.training.user.controller;

import java.util.List;
import java.util.stream.Collectors;

//import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.training.user.dto.UserDto;
import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * UserController, No se usa, es el fichero antes de partirlo en User[_Method}Controller
 */

@RequiredArgsConstructor
//@RestController
//@RequestMapping(path = "/users")
public class UserController {

    public final UserService userService;
    //public final DozerBeanMapper mapper;

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
    public List<UserDto> findAll() {
        List<User> users = userService.findAll();

        //return users.stream().map(u -> mapper.map(u, UserDto.class)).collect(Collectors.toList());
        return users.stream().map(u -> u.toDto()).collect(Collectors.toList());
    }

    /**
     * Method that returns a User
     * 
     * @return {@link User}
     */
    @GetMapping(path = "/{userId}")
    public UserDto findById(@PathVariable(name = "userId") Long userId) {
        //User user = userService.findById(userId);
        //return mapper.map(user, UserDto.class);
        return userService.findById(userId).toDto();

    }

    /**
     * Method that saves a new User: creates a user
     * 
     * @param {@link UserDto}
     */
    @PostMapping(path = "", consumes = { "application/json" })
    public void save(@RequestBody UserDto dto) {
        userService.save(dto);
    }

    /**
     * Method that updates a User
     * 
     * @param userId
     * @param {@link UserDto}
     */
    @PutMapping(path = "/{userId}", consumes = { "application/json" })
    public void update(@PathVariable(name = "userId") Long userId, @RequestBody UserDto dto) throws Exception {
        userService.update(userId, dto);
    }

    //Alternative: Save OrUpdate junto
//    @PutMapping(path = { "", "/{id}" }, consumes = { "application/json" })
//    public void saveOrUpdate(@PathVariable(name = "id") String id, @RequestBody UserDto dto) throws Exception {
//        userService.saveOrUpdate(id, dto);
//    }

    /**
     * Method that delete a User
     * 
     * @param userId  PK of the entity
     */
    @DeleteMapping(path = "/{userId}")
    public void delete(@PathVariable(name = "userId") Long userId) throws Exception {
        userService.delete(userId);
    }

}
