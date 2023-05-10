package com.capgemini.training.controller;

import com.capgemini.training.config.PaymentMapper;
import com.capgemini.training.dto.PaymentDto;
import com.capgemini.training.entity.Beneficiary;
import com.capgemini.training.entity.Payment;
import com.capgemini.training.entity.User;
import com.capgemini.training.service.PaymentGetService;
import java.math.BigDecimal;
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
class PaymentGetControllerTest {

  @Mock private PaymentGetService paymentService;

  @InjectMocks private PaymentGetController paymentController;
  
  public Payment createPayment(Long id, String type) {
    return Payment.builder()
            .paymentId(id)
            .customer( createUser("123456"))
            .beneficiary(createBeneficiary("23456" ))
            .paymentType(type)
            .amount(BigDecimal.valueOf(2000333))
            .creationDate(new Date())
            .build();
  }
  public User createUser(String id) {
    return User.builder()
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
  public Beneficiary createBeneficiary(String id) {
    return Beneficiary.builder()
            .beneficiaryId(id).build();
  }
  @Test
  @DisplayName("Should return a list of payments with HTTP status OK")
  void testGetAllPayments() {
    // given
    List<Payment> users = new ArrayList<>();
    users.add(createPayment(11L, "bizum"));
    users.add(createPayment(12L, "transfer"));

    Mockito.when(paymentService.findAll()).thenReturn(users);

    // when
    ResponseEntity<List<PaymentDto>> response = paymentController.findAll();

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(2, response.getBody().size());
  }

  @Test
  @DisplayName("Should return a Payment with HTTP status OK")
  void testGetUserById() {
    // given
    Long id = 11L;
    Payment expectedUser = createPayment(id, "transfer");
    Optional<Payment> expectedOpt = Optional.of(expectedUser);
    
    Mockito.when(paymentService.findById(id)).thenReturn(expectedOpt);

    // when
    ResponseEntity<PaymentDto> response = paymentController.findById(id);

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    PaymentDto expectedDto = PaymentMapper.toDto(expectedUser);

    Assertions.assertEquals(expectedDto, response.getBody());
  }

  @Test
  @DisplayName("Should return HTTP status NOT_FOUND when Payment not found")
  void testGetUserByIdNotFound() {
    // given
    Long id = 13L;
    Optional<Payment> optData = Optional.empty();

    Mockito.when(paymentService.findById(id)).thenReturn(optData);

    // when
    ResponseEntity<PaymentDto> response = paymentController.findById(id);

    // then
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }
}
