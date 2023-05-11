package com.capgemini.training.controller;

import com.capgemini.training.config.CustomerMapper;
import com.capgemini.training.dto.CustomerDetails;
import com.capgemini.training.entity.CustomerEntity;
import com.capgemini.training.service.CustomerDetailsService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class CustomerDetailsControllerTest {

  @Mock private CustomerDetailsService userService;

  @InjectMocks private CustomerDetailsController userController;

  public CustomerEntity createCustomerEntity(String id) {
    return CustomerEntity.builder()
        .customerId(id)
        .documentType("dni")
        .documentNumber("123" + id)
        .name("john" + id)
        .surname("green" + id)
        .lastname("junior" + id)
        .country("ESP")
        .telephone(123)
        .creationDate(new Date())
        .build();
  }

  @Test
  @DisplayName("When getting all customers it Should return a list of Users with HTTP status OK")
  void testGetAllUsers() {
    // given
    List<CustomerEntity> users = new ArrayList<>();
    users.add(createCustomerEntity("11"));
    users.add(createCustomerEntity("12"));

    Mockito.when(userService.findAll()).thenReturn(users);

    // when
    ResponseEntity<List<CustomerDetails>> response = userController.findAll();

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(2, response.getBody().size());
  }

  @Test
  @DisplayName(
      "When getting existing customer it Should return a CustomerEntity with HTTP status OK")
  void testGetUserById() {
    // given
    String id = "11";
    CustomerEntity expectedUser = createCustomerEntity(id);
    Optional<CustomerEntity> expectedOptUser = Optional.of(expectedUser);
    CustomerDetails expectedDto = CustomerMapper.toDto(expectedUser);

    Mockito.when(userService.findById(id)).thenReturn(expectedOptUser);

    // when
    ResponseEntity<CustomerDetails> response = userController.findById(id);

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(expectedDto, response.getBody());
  }

  @Test
  @DisplayName("When getting non existing customer it Should return HTTP status NOT_FOUND ")
  void testGetUserByIdNotFound() {
    // given
    String id = "12";
    Optional<CustomerEntity> optionalUser = Optional.empty();

    Mockito.when(userService.findById(id)).thenReturn(optionalUser);

    // when
    ResponseEntity<CustomerDetails> response = userController.findById(id);

    // then
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }
}
