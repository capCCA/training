package com.capgemini.training.controller.user;

import com.capgemini.training.repository.models.Customer;
import com.capgemini.training.services.user.GetCustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserGetController {

  private final GetCustomerService getCustomerService;

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
  @GetMapping("users/{customerId}")
  public ResponseEntity getUser( @Valid @PathVariable @NotBlank(message = "ID de usuario no insertado") String customerId) {

      return getCustomerService.getUserById(customerId);

  }
  /*@Operation(summary = "To list all the customers saved in database")
  @GetMapping("users/")
  public ResponseEntity getUsers(){

      return userGetService.getUsers();

  }*/

}
