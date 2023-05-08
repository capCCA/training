package com.capgemini.training.controller.user;

import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.models.Customer;
import com.capgemini.training.services.user.UserGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserGetController {

  private final UserGetService userGetService;

  @Operation(summary = "To list a customer by its ID")
  //Documentating Status codes
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "The customer was correctly listed",
                  content = { @Content(mediaType = "application/json",
                          schema = @Schema(implementation = Customer.class)) }),
          @ApiResponse(responseCode = "404", description = "'ID' does not match with an existing customer",
                  content = @Content),
          @ApiResponse(responseCode = "500", description = "Fail while trying to retrieve the customer.",
                  content = @Content) })
  @GetMapping("user/{customerId}")
  public ResponseEntity getUser(@PathVariable @Valid @NotNull(message = "ID de usuario no insertado") String customerId) {

      return userGetService.getUserById(customerId);

  }
  /*@Operation(summary = "To list all the customers saved in database")
  @GetMapping("users/")
  public ResponseEntity getUsers(){

      return userGetService.getUsers();

  }*/

}
