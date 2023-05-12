package com.capgemini.training.controller;

import static org.mockito.ArgumentMatchers.any;

import com.capgemini.training.dto.CustomerDetails;
import com.capgemini.training.service.NewCustomerDetailsService;
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
class NewCustomerDetailsControllerTest {

  @Mock private NewCustomerDetailsService userService;

  @InjectMocks private NewCustomerDetailsController userController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  public CustomerDetails createUserDto(String id) {
    return CustomerDetails.builder()
        .customerId(id)
        .documentType("DNI")
        .documentNumber("123" + id)
        .name("john" + id)
        .surname("green" + id)
        .lastname("junior" + id)
        .country("ESP")
        .telephone(123)
        .build();
  }

  @Test
  @DisplayName("-Should return a CustomerDetails with HTTP status CREATED 201")
  void testCreateUser_Existing() {
    // given
    String id = "10";
    CustomerDetails expectedDto = createUserDto(id);

    Mockito.when(userService.save(any(CustomerDetails.class))).thenReturn(expectedDto);
    // Mockito.when(userService.save(expectedDto)).thenReturn(expectedDto);

    // when
    ResponseEntity<CustomerDetails> response = userController.save(expectedDto);

    // then
    log.info("responsebody" + response.getBody());
    Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    Assertions.assertEquals(expectedDto, response.getBody()); // fails here
  }

  // @Test
  @DisplayName("--Should fail to create if it already exists, giving HTTP Status  BAD_REQUEST 400 ")
  void testCreateUser_ThatAlreadyExists() {}

  // FAILS
  // Expected :400 BAD_REQUEST
  // Actual :201 CREATED
  @Test
  @DisplayName(
      "-Should fail to create an invalid CustomerEntity (bad country) giving HTTP status BAD_REQUEST ")
  void testCreateUser_WithInvalidCountry() {
    // given
    String id = "11";
    CustomerDetails expectedDto = createUserDto(id);
    expectedDto.setCountry("ESP-BAD");

    Mockito.when(userService.save(any(CustomerDetails.class))).thenReturn(expectedDto);

    // when
    ResponseEntity<CustomerDetails> response = userController.save(expectedDto);

    // then
    Assertions.assertEquals(
        HttpStatus.BAD_REQUEST, response.getStatusCode()); // fails here: 201_CREATED
  }

  // FAILS
  // Expected :400 BAD_REQUEST
  // Actual :201 CREATED
  @Test
  @DisplayName(
      "-Should fail to create an invalid CustomerEntity (bad document Type) giving HTTP status BAD_REQUEST  ")
  void testCreateUser_WithInvalid_DocumentType() {
    // given
    String id = "12";
    CustomerDetails expectedDto = createUserDto(id);
    // expectedDto.setDocumentType(DocumentType.valueOf("BAD_DocumentType"));
    expectedDto.setDocumentType("BAD_DocumentType");

    Mockito.when(userService.save(any(CustomerDetails.class))).thenReturn(expectedDto);

    // when
    ResponseEntity<CustomerDetails> response = userController.save(expectedDto);

    // then
    Assertions.assertEquals(
        HttpStatus.BAD_REQUEST, response.getStatusCode()); // fails here returns 201 CREATED
  }
}
