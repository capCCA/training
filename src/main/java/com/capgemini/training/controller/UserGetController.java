package com.capgemini.training.controller;

import com.capgemini.training.config.UserMapper;
import com.capgemini.training.dto.UserDto;
import com.capgemini.training.entity.User;
import com.capgemini.training.service.UserGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "API of UserGetController")
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserGetController {

  public final UserGetService userService;

  /** method that pings the Controller */
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
   * @return a ResponseEntity of {@link List} of {@link UserDto}
   */
  @Operation(
      summary = "Find all ",
      description = "Method that returns a List of UserDto with status OK 200")
  @GetMapping(path = "")
  public ResponseEntity<List<UserDto>> findAll() {
    List<User> users = userService.findAll();

    return ResponseEntity.ok(users.stream().map(UserMapper::toDto).collect(Collectors.toList()));
  }

  /**
   * Method that returns a User
   *
   * @return a ResponseEntity of {@link UserDto} Status OK 200 or NOT_FOUND 400
   */
  @Operation(
      summary = "Find one ",
      description = "Method that returns a  UserDto with status OK 200 or NOT_FOUND 400")
  @GetMapping(path = "/{userId}")
  public ResponseEntity<UserDto> findById(@PathVariable(name = "userId") @NotBlank String userId) {
    Optional<User> optData = userService.findById(userId);

    return optData
        .map(user -> ResponseEntity.ok(UserMapper.toDto(user)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  
  
  
  
  
  
  
  
  
  
  
  // Notas temporales:
  // lo original antes de ponerlo e orlseGet
  // void findById(...) {
  // Optional<User> optData = userService.findById(userId);
  //  if(optData.isPresent())
  //   return ResponseEntity.ok(UserMapper.toDto(optData.get()));
  // else
  //   return ResponseEntity.notFound().build();

  // before adding ResponseEntity
  // public UserDto findById(@PathVariable(name = "userId") @NotBlank String
  // userId){
  //  return ResponseEntity.ok(UserMapper.toDto(userService.getReferenceById(userId)));
  // }
}
