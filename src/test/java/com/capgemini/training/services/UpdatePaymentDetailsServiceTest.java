package com.capgemini.training.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.capgemini.training.exceptions.PaymentDetailsException;
import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.repository.models.BeneficiaryEntity;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.repository.models.PaymentEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdatePaymentDetailsServiceTest {

  @Mock private PaymentRepository paymentRepository;
  @Mock private CustomerRepository customerRepository;
  @Mock private BeneficiaryRepository beneficiaryRepository;
  @Mock private PaymentMapper paymentMapper;

  @InjectMocks private UpdatePaymentDetailsService updatePaymentDetailsService;
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
            .beneficiary(beneficiaryEntity)
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
  void updatePaymentSuccess() {

    Long customerId = 1L;

    when(paymentRepository.existsById(any())).thenReturn(true);
    when(customerRepository.existsById(any())).thenReturn(true);
    when(beneficiaryRepository.existsById(any())).thenReturn(true);

    when(paymentMapper.toPaymentDetailsResponse(any())).thenReturn(paymentDetailsResponse);

    when(paymentRepository.save(any(PaymentEntity.class))).thenReturn(paymentEntity);

    PaymentDetailsResponse updateCustomerPaymentsResponse =
        updatePaymentDetailsService.updatePayment(paymentEntity);

    assertNotNull(updateCustomerPaymentsResponse);
    verify(customerRepository).existsById(any());
    verify(paymentRepository, times(1)).save(any(PaymentEntity.class));
  }

  @Test
  void updatePaymentsDetailsFailWhileSaving() {

    when(paymentRepository.existsById(any())).thenReturn(true);
    when(customerRepository.existsById(any())).thenReturn(true);
    when(beneficiaryRepository.existsById(any())).thenReturn(true);

    when(paymentMapper.toPaymentDetailsResponse(any()))
        .thenThrow(new PaymentDetailsException("Fallo al intentar de actualizar el pago"));

    assertThatThrownBy(() -> updatePaymentDetailsService.updatePayment(paymentEntity))
        .isInstanceOf(PaymentDetailsException.class)
        .hasMessage("Fallo al intentar de actualizar el pago");
    verify(beneficiaryRepository).existsById(any());
  }

}
