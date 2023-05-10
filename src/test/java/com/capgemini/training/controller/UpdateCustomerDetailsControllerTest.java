package com.capgemini.training.controller;

import com.capgemini.training.dto.CustomerDetails;
import com.capgemini.training.dto.DocumentType;
import com.capgemini.training.service.UpdateCustomerDetailsService;
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
class UpdateCustomerDetailsControllerTest {

  @Mock private UpdateCustomerDetailsService userService;

  @InjectMocks private UpdateCustomerDetailsController userController;

  public CustomerDetails createUserDto(String id) {
    return CustomerDetails.builder()
        .customerId(id)
        .documentType(DocumentType.valueOf("PASSPORT"))
        .documentNumber("123" + id)
        .name("john" + id)
        .surname("green" + id)
        .lastname("junior" + id)
        .country("ESP")
        .telephone(123)
        .build();
  }

  @Test
  @DisplayName("Should update a CustomerDetails with HTTP status OK")
  void testUpdateUser() {
    // given
    String id = "11";
    CustomerDetails expectedDto = createUserDto(id);

    Mockito.when(userService.update(id, ArgumentMatchers.any(CustomerDetails.class))).thenReturn(expectedDto);

    // when
    ResponseEntity<CustomerDetails> response = userController.update(id, expectedDto);

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(expectedDto, response.getBody());

  }

  @Test
  @DisplayName("Should fail to update  CustomerDetails  and return with HTTP status NOT_FOUND ")
  void testUpdateUserNotFound() {}
}
