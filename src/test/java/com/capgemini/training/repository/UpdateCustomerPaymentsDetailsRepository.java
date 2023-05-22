package com.capgemini.training.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.controllers.NewPaymentDetailsController;
import com.capgemini.training.controllers.UpdatePaymentDetailsController;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UpdateCustomerPaymentsDetailsRepository {

  @Mock private UpdatePaymentDetailsService updatePaymentDetailsService;
  @InjectMocks private UpdatePaymentDetailsController updatePaymentDetailsController;

  private PaymentDetailsResponse paymentDetailsResponse;
  private PaymentDetailsRequest paymentDetailsRequest;
  private CustomerEntity customerEntity;
  private PaymentEntity paymentEntity;
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
  void getCustomerPaymentsDetailsQueryOK() {

    Long customerId = 1L;

    when(updatePaymentDetailsService.updatePayment(paymentEntity))
        .thenReturn(paymentDetailsResponse);

    ResponseEntity<PaymentDetailsResponse> controllerResponse =
        updatePaymentDetailsController.updateUser(paymentEntity);

    assertNotNull(controllerResponse);
    assertEquals("Albert", controllerResponse.getBody().getCustomer().getName());
    assertEquals("USA", controllerResponse.getBody().getCustomer().getCountry());

    verify(updatePaymentDetailsService).updatePayment(any());
  }
}
