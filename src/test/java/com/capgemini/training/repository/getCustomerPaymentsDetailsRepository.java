package com.capgemini.training.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.controllers.getCustomerPaymentsDetailsController;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.services.getCustomerPaymentsDetailsService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class getCustomerPaymentsDetailsRepository {

  @Mock private getCustomerPaymentsDetailsService getCustomerPaymentsDetailsService;
  @InjectMocks private getCustomerPaymentsDetailsController getCustomerPaymentsDetailsController;

  private PaymentDetailsResponse paymentDetailsResponse;
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
  }

  @Test
  void getCustomerPaymentsDetailsQueryOK() {

    Long customerId = 1L;

    List<PaymentDetailsResponse> serviceResponse = Arrays.asList(paymentDetailsResponse);

    when(getCustomerPaymentsDetailsService.getCustomerPaymentsDetails(customerId))
        .thenReturn(serviceResponse);

    ResponseEntity<List<PaymentDetailsResponse>> controllerResponse = getCustomerPaymentsDetailsController.getCustomerPaymentsDetails(customerId);

    assertNotNull(controllerResponse);
    assertEquals("Albert" ,serviceResponse.get(0).getCustomer().getName());
    assertEquals("USA" ,serviceResponse.get(0).getCustomer().getCountry());

    verify(getCustomerPaymentsDetailsService).getCustomerPaymentsDetails(customerId);
  }
}
