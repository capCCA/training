package com.capgemini.training.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.controllers.NewPaymentDetailsController;
import com.capgemini.training.models.PaymentDetailsRequest;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.services.NewPaymentDetailsService;
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
public class NewCustomerPaymentsDetailsRepository {

  @Mock private NewPaymentDetailsService newPaymentDetailsService;
  @InjectMocks private NewPaymentDetailsController newPaymentDetailsController;

  private PaymentDetailsResponse paymentDetailsResponse;
  private PaymentDetailsRequest paymentDetailsRequest;
  private CustomerEntity customerEntity;

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
  }

  @Test
  void getCustomerPaymentsDetailsQueryOK() {

    Long customerId = 1L;

    when(newPaymentDetailsService.createNewPayment(paymentDetailsRequest))
        .thenReturn(paymentDetailsResponse);

    ResponseEntity<PaymentDetailsResponse> controllerResponse =
        newPaymentDetailsController.createNewPayment(paymentDetailsRequest);

    assertNotNull(controllerResponse);
    assertEquals("Albert", controllerResponse.getBody().getCustomer().getName());
    assertEquals("USA", controllerResponse.getBody().getCustomer().getCountry());

    verify(newPaymentDetailsService).createNewPayment(paymentDetailsRequest);
  }
}
