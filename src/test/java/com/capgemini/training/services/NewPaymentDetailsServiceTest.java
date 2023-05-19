package com.capgemini.training.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import com.capgemini.training.exceptions.PaymentDetailsException;
import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentDetailsRequest;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.repository.models.BeneficiaryEntity;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.repository.models.PaymentEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NewPaymentDetailsServiceTest {

  @Mock private PaymentRepository paymentRepository;
  @Mock private CustomerRepository customerRepository;
  @Mock private BeneficiaryRepository beneficiaryRepository;
  @Mock private PaymentMapper paymentMapper;

  @InjectMocks private NewPaymentDetailsService newPaymentDetailsService;
  private PaymentEntity paymentEntity;
  private PaymentDetailsResponse paymentDetailsResponse;
  private CustomerEntity customerEntity;
  private BeneficiaryEntity beneficiaryEntity;
  private PaymentDetailsRequest paymentDetailsRequest;

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
  void createNewPaymentSuccess() {

    Long customerId = 1L;
    when(customerRepository.existsById(any())).thenReturn(true);
    when(beneficiaryRepository.existsById(any())).thenReturn(true);
    when(paymentMapper.toPaymentDetailsResponse(any())).thenReturn(paymentDetailsResponse);

    when(customerRepository.findById(any())).thenReturn(Optional.of(customerEntity));
    when(beneficiaryRepository.findById(any())).thenReturn(Optional.of(beneficiaryEntity));

    when(paymentRepository.save(any(PaymentEntity.class))).thenReturn(paymentEntity);

    when(paymentMapper.toEntityFromRequest(
            paymentDetailsRequest, customerEntity, beneficiaryEntity))
        .thenReturn(paymentEntity);

    PaymentDetailsResponse getCustomerPaymentDetailsResponse =
        newPaymentDetailsService.createNewPayment(paymentDetailsRequest);

    assertEquals(Optional.of(customerEntity), customerRepository.findById(any()));
    assertNotNull(getCustomerPaymentDetailsResponse);
    verify(customerRepository).existsById(any());
    verify(paymentRepository, times(1)).save(any(PaymentEntity.class));
  }

  @Test
  void createNewPaymentSomeDetailsAreWrong() {
    when(customerRepository.existsById(any())).thenReturn(true);
    when(beneficiaryRepository.existsById(any())).thenReturn(false);

    assertThatThrownBy(() -> newPaymentDetailsService.createNewPayment(paymentDetailsRequest))
        .isInstanceOf(PaymentDetailsException.class)
        .hasMessage("Algun detalle no se ha insertado correctamente");
  }

  @Test
  void createNewPaymentFailWhileSaving() {

    when(customerRepository.existsById(any())).thenReturn(true);
    when(beneficiaryRepository.existsById(any())).thenReturn(true);

    when(customerRepository.findById(any())).thenReturn(Optional.of(customerEntity));
    when(beneficiaryRepository.findById(any())).thenReturn(Optional.of(beneficiaryEntity));

    when(paymentMapper.toEntityFromRequest(
            paymentDetailsRequest, customerEntity, beneficiaryEntity))
        .thenThrow(new PaymentDetailsException("Fallo al crear pago"));

    assertThatThrownBy(() -> newPaymentDetailsService.createNewPayment(paymentDetailsRequest))
        .isInstanceOf(PaymentDetailsException.class)
        .hasMessage("Fallo al crear pago");

    assertNotNull(Optional.of(customerEntity));

    verify(customerRepository).findById(any());
    verify(customerRepository).existsById(any());
  }
}
