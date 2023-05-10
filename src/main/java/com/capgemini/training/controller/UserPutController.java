package com.capgemini.training.controller;

import com.capgemini.training.dto.UserDto;
import com.capgemini.training.service.UserPutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "API of UserPutController")
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Log
public class UserPutController {

  public final UserPutService userService;

  /**
   * Method that updates a UserDto c
   *
   * @param userId
   * @param {@link UserDto}
   */
  @Operation(summary = "Update ", description = "Method that updates a User with status OK 200 or EXPECTATION_FAILED if exception occurs. IF not valid UserDto BAD_REQUEST ")
  @PutMapping(
      path = "/{userId}",
      consumes = {"application/json"})
  public ResponseEntity<UserDto> update(
      @PathVariable(name = "userId") @NotBlank String userId, @Valid @RequestBody UserDto dto) {
    try {
      return ResponseEntity.ok(userService.update(userId, dto));
    } catch (Exception e) {
      log.info("Problem found :" + e.getMessage());
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }
  }
}
