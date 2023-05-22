package com.capgemini.training.controllers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.exceptions.PaymentDetailsException;
import com.capgemini.training.models.PaymentDetailsRequest;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.models.BeneficiaryEntity;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.repository.models.PaymentEntity;
import com.capgemini.training.services.UpdatePaymentDetailsService;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class UpdatePaymentDetailsControllerTest {

  @InjectMocks private UpdatePaymentDetailsController updatePaymentDetailsController;
  @Mock private UpdatePaymentDetailsService updatePaymentDetailsService;
  private PaymentDetailsResponse paymentDetailsResponse;
  private CustomerEntity customerEntity;
  private PaymentEntity paymentEntity;
  private PaymentDetailsRequest paymentDetailsRequest;
  private BeneficiaryEntity beneficiaryEntity;

  @BeforeEach
  void setUp() {
    customerEntity =
        CustomerEntity.builder()
            .customerId("1")
            .name("Albert")
            .surname("Romero")
            .country("USA")
            .build();

    paymentDetailsResponse =
        PaymentDetailsResponse.builder()
            .paymentId(1L)
            .customer(customerEntity)
            .paymentType("Credit")
            .amount(BigDecimal.valueOf(100.0))
            .creationDate(LocalDate.now())
            .updateDate(LocalDate.ofEpochDay(01 - 02 - 2023))
            .build();

    paymentDetailsRequest =
        PaymentDetailsRequest.builder()
            .paymentId(1L)
            .customerId("1")
            .beneficiaryId("Ben1")
            .paymentType("Credit")
            .amount(BigDecimal.valueOf(100.0))
            .creationDate(LocalDate.now())
            .updateDate(LocalDate.ofEpochDay(01 - 02 - 2023))
            .build();

    beneficiaryEntity =
        BeneficiaryEntity.builder()
            .beneficiaryId("1")
            .creationDate(LocalDate.ofEpochDay(20 - 04 - 2023))
            .updateDate(LocalDate.ofEpochDay(10 - 02 - 2021))
            .build();

    paymentEntity =
        PaymentEntity.builder()
            .customer(customerEntity)
            .beneficiary(beneficiaryEntity)
            .paymentId(3L)
            .paymentType("TRANSFER")
            .amount(BigDecimal.valueOf(2))
            .creationDate(LocalDate.now())
            .updateDate(LocalDate.ofEpochDay(20 - 02 - 2022))
            .build();
  }

  @Test
  void updatePaymentSuccess() {

    when(updatePaymentDetailsService.updatePayment(paymentEntity))
        .thenReturn(paymentDetailsResponse);

    ResponseEntity<PaymentDetailsResponse> controllerResponse =
        updatePaymentDetailsController.updateUser(paymentEntity);

    assertNotNull(controllerResponse);
    assertEquals(HttpStatus.OK, controllerResponse.getStatusCode());
    assertEquals(controllerResponse.getBody(), paymentDetailsResponse);
    verify(updatePaymentDetailsService).updatePayment(any());
  }

  @Test
  void updatePaymentErrorWhileUpdating(){

    when(updatePaymentDetailsService.updatePayment(paymentEntity))
        .thenThrow(new PaymentDetailsException("Fallo al intentar de actualizar el pago"));

    assertThatThrownBy(() -> updatePaymentDetailsService.updatePayment(paymentEntity))
            .isInstanceOf(PaymentDetailsException.class)
            .hasMessage("Fallo al intentar de actualizar el pago");
  }
  @Test
  void updatePaymentSomeDetailsAreWrong(){

    when(updatePaymentDetailsService.updatePayment(paymentEntity))
            .thenThrow(new PaymentDetailsException("Algun detalle no se ha insertado correctamente"));

    assertThatThrownBy(() -> updatePaymentDetailsService.updatePayment(paymentEntity))
            .isInstanceOf(PaymentDetailsException.class)
            .hasMessage("Algun detalle no se ha insertado correctamente");
  }

}
