package com.capgemini.training.controller;

import com.capgemini.training.dto.CustomerDetails;
import com.capgemini.training.service.UpdateCustomerDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "CustomerEntity", description = "API of UserPutController")
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Log

public class UpdateCustomerDetailsController {

  public final UpdateCustomerDetailsService userService;

  /**
   * Method that updates a CustomerDetails c
   *
   * @param userId
   * @param {@link CustomerDetails}
   */
  @Operation(
      summary = "Update ",
      description =
          "Method that updates a CustomerEntity with status OK 200 or EXPECTATION_FAILED 417 if exception occurs. IF not valid CustomerDetails BAD_REQUEST 400")
  @PutMapping(
      path = "/{userId}",
      consumes = {"application/json"})
  public ResponseEntity<CustomerDetails> update(
      @PathVariable(name = "userId") @NotBlank @NotNull String userId,
      @Valid @RequestBody com.capgemini.training.dto.CustomerDetails dto) {

    return ResponseEntity.ok(userService.update(userId, dto));
  }
}

// Nota:sin usar GlobalExceptionHandler
//
//  public ResponseEntity<CustomerDetails> update(
//      @PathVariable(name = "userId") @NotBlank String userId, @Valid @RequestBody CustomerDetails
// dto) {
//     try {
//      return ResponseEntity.ok(userService.update(userId, dto));
//    } catch (CustomerNotFoundException e) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//      } catch(MethodArgumentNotValidException e){
//        log.info("Problem found :" + e.getMessage());
//        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
//      }
//    }
