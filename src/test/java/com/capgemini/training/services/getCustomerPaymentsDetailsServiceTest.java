package com.capgemini.training.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.capgemini.training.exceptions.PaymentDetailsException;
import com.capgemini.training.exceptions.PaymentNotFoundException;
import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.repository.models.BeneficiaryEntity;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.repository.models.PaymentEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class getCustomerPaymentsDetailsServiceTest {

  @Mock private PaymentRepository paymentRepository;
  @Mock private PaymentMapper paymentMapper;

  @InjectMocks private getCustomerPaymentsDetailsService getCustomerPaymentsDetailsService;
  private PaymentEntity paymentEntity;
  private PaymentDetailsResponse paymentDetailsResponse;
  private CustomerEntity customerEntity;
  private BeneficiaryEntity beneficiaryEntity;

  @BeforeEach
  void setUp() {

    // Mocks entities
    customerEntity =
        CustomerEntity.builder()
            .customerId("1")
            .name("Albert")
            .surname("Romero")
            .country("USA")
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
            .beneficiary(any())
            .paymentId(3L)
            .paymentType("TRANSFER")
            .amount(BigDecimal.valueOf(2))
            .creationDate(LocalDate.now())
            .updateDate(LocalDate.ofEpochDay(20 - 02 - 2022))
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
  void getCustomerPaymentsDetailsSuccess() {

    long customerId = 1L;

    when(paymentRepository.existsById(customerId)).thenReturn(true);
    when(paymentRepository.findById(customerId)).thenReturn(Optional.of(paymentEntity));
    when(paymentMapper.toPaymentDetailsResponse(paymentEntity)).thenReturn(paymentDetailsResponse);

    List<PaymentDetailsResponse> mockListingPaymentsCustomer =
        getCustomerPaymentsDetailsService.getCustomerPaymentsDetails(customerId);

    assertEquals(1, mockListingPaymentsCustomer.size());
    assertEquals(paymentDetailsResponse, mockListingPaymentsCustomer.get(0));
  }

  @Test
  void getCustomerPaymentsDetailsNotFound() {

    long customerId = 1L;

    when(paymentRepository.existsById(customerId)).thenReturn(false);

    assertThatThrownBy(
            () -> getCustomerPaymentsDetailsService.getCustomerPaymentsDetails(customerId))
        .isInstanceOf(PaymentNotFoundException.class);
    verify(paymentRepository, times(1)).existsById(any());
  }

  @Test
  void getCustomerPaymentsAnyOtherError() {

    long customerId = 1L;

    when(paymentRepository.existsById(customerId)).thenReturn(true);
    when(paymentRepository.findById(customerId)).thenReturn(Optional.of(paymentEntity));

    when(paymentMapper.toPaymentDetailsResponse(paymentEntity))
        .thenThrow(new PaymentDetailsException("Fallo al intentar devolver la lista de pagos"));

    assertThatThrownBy(
            () -> getCustomerPaymentsDetailsService.getCustomerPaymentsDetails(customerId))
        .isInstanceOf(PaymentDetailsException.class)
        .hasMessage("Fallo al intentar devolver la lista de pagos");
    verify(paymentRepository).findById(customerId);
  }
}
