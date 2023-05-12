package com.capgemini.training.controller;

import static org.mockito.Mockito.verify;

import com.capgemini.training.dto.CustomerDetails;
import com.capgemini.training.errors.CustomerNotFoundException;
import com.capgemini.training.service.UpdateCustomerDetailsService;
import lombok.extern.java.Log;
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

@Log
@ExtendWith(MockitoExtension.class)
class UpdateCustomerDetailsControllerTest {

  @Mock private UpdateCustomerDetailsService userService;

  @InjectMocks private UpdateCustomerDetailsController userController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  public CustomerDetails createUserDto(String id) {
    return CustomerDetails.builder()
        .customerId(id)
        // .documentType(DocumentType.valueOf("PASSPORT"))
        .documentType("PASSPORT")
        .documentNumber("123" + id)
        .name("john" + id)
        .surname("green" + id)
        .lastname("junior" + id)
        .country("ESP")
        .telephone(123)
        .build();
  }

  //
  @Test
  @DisplayName("--Should update a CustomerDetails with HTTP status OK")
  void testUpdateUser() {
    // given
    String id = "11";
    CustomerDetails expectedDto = createUserDto(id);

    Mockito.when(userService.update(id, expectedDto)).thenReturn(expectedDto);
    // userService.update(userId, dto)
    // when
    ResponseEntity<CustomerDetails> response = userController.update(id, expectedDto);

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(expectedDto, response.getBody()); // fails here
    verify(userService).update(id, expectedDto);
  }

  // Fails: Returns OK
  @Test
  @DisplayName("--Should fail to update CustomerDetails and throws CustomerNotFoundException ")
  void testUpdateUserNotFound() {
    Throwable exceptionExpected = null;
    String id = "11";
    CustomerDetails expectedDto = createUserDto(id);

    Mockito.when(userService.update(id, expectedDto)).thenReturn(null);

    // Exception.

    // when
    ResponseEntity<CustomerDetails> response = null;
    try {
      response = userController.update(id, expectedDto);
      Assertions.fail("Expected a CustomerNotFoundException to be thrown");
    } catch (CustomerNotFoundException e) {
      exceptionExpected = e;
      log.info("Expected exception " + e.getMessage());
    }
    log.info("response " + response);

    // then
    Assertions.assertTrue( exceptionExpected instanceof CustomerNotFoundException);
  }
}
