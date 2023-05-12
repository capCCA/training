package com.capgemini.training.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.service.DeleteCustomerDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class DeleteCustomerDetailsControllerTest {

  @Mock private DeleteCustomerDetailsService userService;

  @InjectMocks private DeleteCustomerDetailsController userController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }
  // Mockito does not work for void methods, use doNothing o doAnswer..
  // https://stacktraceguru.com/unittest/mock-void-method

  @Test
  @DisplayName("--Should return HTTP status NOT_FOUND")
  void testDeleteUserNotFound_Old()  {
    Throwable exceptionExpected = null;
    // given
    String id = "99";
    Mockito.doNothing().when(userService).delete(id);

    ResponseEntity<Void> response = null;
    // when
    try {
      response = userController.delete(id);

    } catch (CustomerNotFoundException e) {
      exceptionExpected = e;
    }

    // then
    Assertions.assertTrue(exceptionExpected instanceof CustomerNotFoundException);
  }

  @Test
  @DisplayName("--Should throw CustomerNotFoundException")
  void testDeleteUserNotFound_new() throws Exception {
    // given
    String customerId = "99";
    doNothing().when(userService).delete(customerId);
    assertThrows (CustomerNotFoundException.class, () -> userController.delete(customerId));

    verify(userService).delete(customerId);
  }

  @Test
  @DisplayName("--Should return HTTP status OK ")
  void testDeleteUserSuccess() {
    // given
    String customerId = "11";
    doNothing().when(userService).delete(customerId);
    assertDoesNotThrow(() -> userController.delete(customerId));

    // when
    ResponseEntity<Void> response = userController.delete(customerId);

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
  }
}
