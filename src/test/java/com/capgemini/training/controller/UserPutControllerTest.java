package com.capgemini.training.controller;

import com.capgemini.training.dto.UserDto;
import com.capgemini.training.service.UserPutService;
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
class UserPutControllerTest {

  @Mock private UserPutService userService;

  @InjectMocks private UserPutController userController;

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

  @Test
  @DisplayName("Should update a UserDto with HTTP status OK")
  void testUpdateUser() {
    // given
    String id = "11";
    UserDto expectedDto = createUserDto(id);

    try{
    Mockito.when(userService.update(id,ArgumentMatchers.any(UserDto.class))).thenReturn(expectedDto);
    } catch(Exception e){

    }

    // when
    ResponseEntity<UserDto> response = userController.update(id, expectedDto);

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(expectedDto, response.getBody());

  }

  @Test
  @DisplayName("Should update a UserDto with HTTP status NOT_FOUND")
  void testUpdateUserNotFound() {}
}
