package com.capgemini.training.controller;

import com.capgemini.training.dto.UserDto;
import com.capgemini.training.service.UserPostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class UserPostControllerTest {

  @Mock private UserPostService userService;

  @InjectMocks private UserPostController userController;

  public UserDto createUserDto(String id) {
    return UserDto.builder()
        .customerId(id)
        .documentType("dni")
        .documentNumber("123" + id)
        .name("john" + id)
        .surname("green" + id)
        .lastname("junior" + id)
        .country("ESP")
        .telephone(123)
        .build();
  }
  public UserDto createBadUserDto(String id) {
    return UserDto.builder()
            .customerId(id)
            .documentType("dni")
            .documentNumber("123" + id)
            .name("john" + id)
            .surname("green" + id)
            .lastname("junior" + id)
            .country("ESP--------")
            .telephone(123)
            .build();
  }


  @Test
  @DisplayName("Should return a UserDto with HTTP status CREATED")
  void testCreateUser() {
    // given
    String id = "10";
    UserDto expectedDto = createUserDto(id);

    Mockito.when(userService.save(ArgumentMatchers.any(UserDto.class))).thenReturn(expectedDto);

    // when
    ResponseEntity<UserDto> response = userController.save(expectedDto);

    // then
    Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    Assertions.assertEquals(expectedDto, response.getBody());
  }

  //Fails: todo fix:
  //Expected :400 BAD_REQUEST
  //Actual   :201 CREATED
  @Test
  @DisplayName("Should fail to create an invalid User (bad country) giving HTTP status BAD_REQUEST ")
  void testCreateUserWithInvalidCountry() {
    // given
    String id = "11";
    UserDto expectedDto =createBadUserDto(id);

    Mockito.when(userService.save(ArgumentMatchers.any(UserDto.class))).thenReturn(expectedDto);

    // when
    ResponseEntity<UserDto> response = userController.save(expectedDto);

    // then
    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

  }

  //Fails: todo fix
  //Expected :417 EXPECTATION_FAILED
  //Actual   :201 CREATED
  @Test
  @DisplayName("Should fail to create an invalid User (bad document Type) giving HTTP status EXPECTATION_FAILED  ")
  void testCreateUserWithInvalidDocumentType() {
    // given
    String id = "12";
    UserDto expectedDto = createUserDto(id);
    expectedDto.setDocumentType("BAD_DocumentType");

    Mockito.when(userService.save(ArgumentMatchers.any(UserDto.class))).thenReturn(expectedDto);

    // when
    ResponseEntity<UserDto> response = userController.save(expectedDto);

    // then
    Assertions.assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());

  }
}
