package com.capgemini.training.controller;

import com.capgemini.training.service.DeleteCustomerDetailsService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteCustomerDetailsControllerTest {

  @Mock private DeleteCustomerDetailsService userService;

  @InjectMocks private DeleteCustomerDetailsController userController;


//  @Test
//  @DisplayName("Should return HTTP status NOT_FOUND when CustomerEntity not found for deleteUser")
//  void testDeleteUserNotFound() throws Exception {
//    // given
//    String id = "99";
//
//    when(userService.delete(id)).thenReturn(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
//
//    // when
//    ResponseEntity<Void> response = userController.userService.delete(id);
//
//    // then
//    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//  }
//
//  @Test
//  @DisplayName("Should return HTTP status OK when CustomerEntity deleted successfully for deleteUser")
//  void testDeleteUserSuccess()  {
//    // given
//    String id = "11";
//    when(userService.delete(id)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
//
//    // when
//    ResponseEntity<Void> response = userController.delete(id);
//
//    // then
//    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
//  }
}
