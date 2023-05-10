package com.capgemini.training.controller;

import com.capgemini.training.service.UserDeleteService;
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
class UserDeleteControllerTest {

  @Mock private UserDeleteService userService;

  @InjectMocks private UserDeleteController userController;


  @Test
  @DisplayName("Should return HTTP status NOT_FOUND when User not found for deleteUser")
  void testDeleteUserNotFound() throws Exception {
    // given
    String id = "99";

    Mockito.when(userService.delete(id)).thenReturn(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));

    // when
    ResponseEntity<Void> response = userController.userService.delete(id);

    // then
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }

  @Test
  @DisplayName("Should return HTTP status OK when User deleted successfully for deleteUser")
  void testDeleteUserSuccess()  {
    // given
    String id = "11";
    Mockito.when(userService.delete(id)).thenReturn(new ResponseEntity<>(HttpStatus.OK));

    // when
    ResponseEntity<Void> response = userController.delete(id);

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
  }
}
