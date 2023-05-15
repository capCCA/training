package com.capgemini.training.controller;

import com.capgemini.training.api.controller.PaymentDetailsController;
import com.capgemini.training.api.model.PaymentDetails;
import com.capgemini.training.api.repository.model.BeneficiaryEntity;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.repository.model.PaymentEntity;
import com.capgemini.training.api.service.PaymentDetailsService;
import com.capgemini.training.api.service.mapper.PaymentMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class PaymentDetailsControllerTest {

  @Mock private PaymentDetailsService paymentService;

  @InjectMocks private PaymentDetailsController paymentController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  public PaymentEntity createPayment(Long id, String type) {
    return PaymentEntity.builder()
        .paymentId(id)
        .customer(createUser("123456"))
        .beneficiary(createBeneficiary("23456"))
        .paymentType(type)
        .amount(BigDecimal.valueOf(2000333))
        .creationDate(new Date())
        .build();
  }

  public CustomerEntity createUser(String id) {
    return CustomerEntity.builder()
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

  public BeneficiaryEntity createBeneficiary(String id) {
    return BeneficiaryEntity.builder().beneficiaryId(id).build();
  }

  @Test
  @DisplayName("Should return a list of payments with HTTP status OK")
  void testGetAllPayments() {
    // given
    List<PaymentEntity> payments = new ArrayList<>();
    payments.add(createPayment(11L, "bizum"));
    payments.add(createPayment(12L, "transfer"));

    Mockito.when(paymentService.findAll()).thenReturn(payments);

    // when
    ResponseEntity<List<PaymentDetails>> response = paymentController.findAll();

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(2, response.getBody().size());
  }

  @Test
  @DisplayName("Should return a PaymentEntity with HTTP status OK")
  void testGetUserById() {
    // given
    Long id = 11L;
    PaymentEntity expectedUser = createPayment(id, "transfer");

    Mockito.when(paymentService.findById(id)).thenReturn(Optional.of(expectedUser));

    // when
    ResponseEntity<PaymentDetails> response = paymentController.findById(id);

    // then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    PaymentDetails expectedDto = PaymentMapper.toDto(expectedUser);

    Assertions.assertEquals(expectedDto, response.getBody());
  }

  @Test
  @DisplayName("Should return HTTP status NOT_FOUND when PaymentEntity not found")
  void testGetUserByIdNotFound() {
    // given
    Long id = 13L;

    Mockito.when(paymentService.findById(id)).thenReturn(Optional.empty());

    // when
    ResponseEntity<PaymentDetails> response = paymentController.findById(id);

    // then
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }
}
