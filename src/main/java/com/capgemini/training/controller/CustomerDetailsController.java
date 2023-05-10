package com.capgemini.training.controller;

import com.capgemini.training.config.CustomerMapper;
import com.capgemini.training.dto.CustomerDetails;
import com.capgemini.training.entity.CustomerEntity;
import com.capgemini.training.service.CustomerDetailsService;
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

@Tag(name = "CustomerEntity", description = "API of UserGetController")
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class CustomerDetailsController {

  public final CustomerDetailsService userService;

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
   * @return a ResponseEntity of {@link List} of {@link CustomerDetails}
   */
  @Operation(
      summary = "Find all ",
      description = "Method that returns a List of CustomerDetails with status OK 200")
  @GetMapping(path = "")
  public ResponseEntity<List<CustomerDetails>> findAll() {
    List<CustomerEntity> users = userService.findAll();

    return ResponseEntity.ok(users.stream().map(CustomerMapper::toDto).collect(Collectors.toList()));
  }

  /**
   * Method that returns a CustomerEntity
   *
   * @return a ResponseEntity of {@link CustomerDetails} Status OK 200 or NOT_FOUND 400
   */
  @Operation(
      summary = "Find one ",
      description = "Method that returns a  CustomerDetails with status OK 200 or NOT_FOUND 400")
  @GetMapping(path = "/{userId}")
  public ResponseEntity<CustomerDetails> findById(@PathVariable(name = "userId") @NotBlank String userId) {
    Optional<CustomerEntity> optData = userService.findById(userId);

    return optData
        .map(user -> ResponseEntity.ok(CustomerMapper.toDto(user)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  
  
  
  
  
  
  
  
  
  
  
  // Notas temporales:
  // lo original antes de ponerlo e orlseGet
  // void findById(...) {
  // Optional<CustomerEntity> optData = userService.findById(userId);
  //  if(optData.isPresent())
  //   return ResponseEntity.ok(CustomerMapper.toDto(optData.get()));
  // else
  //   return ResponseEntity.notFound().build();

  // before adding ResponseEntity
  // public CustomerDetails findById(@PathVariable(name = "userId") @NotBlank String
  // userId){
  //  return ResponseEntity.ok(CustomerMapper.toDto(userService.getReferenceById(userId)));
  // }
}
