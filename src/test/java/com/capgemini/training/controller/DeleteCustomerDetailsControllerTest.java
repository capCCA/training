package com.capgemini.training.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.service.DeleteCustomerDetailsService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class DeleteCustomerDetailsControllerTest {

  @Mock private DeleteCustomerDetailsService userService;

  @InjectMocks private DeleteCustomerDetailsController userController;

  /*  si se usa @ExtendWith no hace falta.
  private AutoCloseable closeable;

  @BeforeEach
  public void setUp() {
    closeable=MockitoAnnotations.openMocks(this);
  }

  @AfterEach public void releaseMocks() throws Exception {
    closeable.close();
  }
  */
  // Mockito does not work for void methods, use doNothing o doAnswer..
  // https://stacktraceguru.com/unittest/mock-void-method

  @Test
  @DisplayName("Should throw CustomerNotFoundException ")
  void testDeleteUserNotFound_OldStyle() {
    Throwable exceptionExpected = null;
    // given
    String id = "99";
    Mockito.doThrow(CustomerNotFoundException.class).when(userService).delete(id);

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
  @DisplayName("Should throw CustomerNotFoundException")
  void testDeleteUserNotFound_NewStlyle() {
    // given
    doThrow(CustomerNotFoundException.class).when(userService).delete(anyString());

    assertThrows(CustomerNotFoundException.class, () -> userController.delete(anyString()));
    // fails here

    verify(userService).delete(anyString());
  }

  @Test
  @DisplayName("Should return HTTP status OK ")
  void testDeleteUserSuccess() {
    // given
    String customerId = "11";
    doNothing().when(userService).delete(anyString());
    assertDoesNotThrow(() -> userController.delete(customerId)); // 1st time

    // when
    ResponseEntity<Void> response = userController.delete(customerId); // 2nd time

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    verify(userService, times(2)).delete(anyString());
  }
}
