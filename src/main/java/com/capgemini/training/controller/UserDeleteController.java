package com.capgemini.training.controller;

import com.capgemini.training.service.UserDeleteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "API of UserDeleteController with status OK 200 or NOT_FOUND 404")
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserDeleteController {

  public final UserDeleteService userService;

  /**
   * Method that delete a User
   *
   * @param userId PK of the entity
   * @return 200 OK or 404 Not FOUND
   */
  @Operation(
      summary = "Delete ",
      description = "Method that deletes a User with status OK 200 or 404 NOT_FOUND")
  @DeleteMapping(path = "/{userId}")
  public ResponseEntity<Void> delete(@PathVariable(name = "userId") @NotBlank String userId) {
    return userService.delete(userId);
  }
}
