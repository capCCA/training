package com.capgemini.training.controller;

import com.capgemini.training.dto.UserDto;
import com.capgemini.training.service.UserPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "API of UserPostController")
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Log
public class UserPostController {

  public final UserPostService userService;

  /**
   * Method that saves a new User: creates a user
   *
   * @param {@link UserDto}
   * @return {@link ResponseEntity } of {@link UserDto} with status 201 CREATED
   */
  @Operation(summary = "Save ", description = "Method that saves a User")
  @PostMapping(
      path = "",
      consumes = {"application/json"})
  public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto dto) {
    try {
      UserDto savedDto = userService.save(dto);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    } catch (Exception e) { // MethodArgumentNotValidException  if @Valid fails-> ya va a BAD_REQUEST-
      log.info("Problem found :" + e.getMessage());
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build(); // for check Type fail
    }
  }
}

// Note: the same
// return ResponseEntity.status(HttpStatus.OK).body(userService.save(dto));
//
//  return ResponseEntity.ok(userService.save(dto));
//
//
