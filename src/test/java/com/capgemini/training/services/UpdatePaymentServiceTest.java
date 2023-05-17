package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.capgemini.training.errors.exceptions.BeneficiaryNotFoundException;
import com.capgemini.training.errors.exceptions.CustomerNotFoundException;
import com.capgemini.training.errors.exceptions.PaymentNotFoundException;
import com.capgemini.training.models.BeneficiaryResponse;
import com.capgemini.training.models.CustomerResponse;
import com.capgemini.training.models.PaymentRequest;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.repositories.BeneficiaryRepository;
import com.capgemini.training.repositories.CustomerRepository;
import com.capgemini.training.repositories.PaymentRepository;
import com.capgemini.training.repositories.models.BeneficiaryEntity;
import com.capgemini.training.repositories.models.CustomerEntity;
import com.capgemini.training.repositories.models.PaymentEntity;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdatePaymentServiceTest {

  @InjectMocks private UpdatePaymentService updatePaymentService;
  @Mock private PaymentRepository paymentRepository;
  @Mock private CustomerRepository customerRepository;
  @Mock private BeneficiaryRepository beneficiaryRepository;

  @Test
  void shouldReturnPaymentWhenCustomerIsUpdate() {
    PaymentResponse expectedPaymentsResponse =
        PaymentResponse.builder()
            .paymentId(12L)
            .customer(
                CustomerResponse.builder()
                    .customerId("1")
                    .name("Alba")
                    .documentType("DNI")
                    .documentNumber("123456")
                    .country("ESP")
                    .surname("")
                    .build())
            .beneficiary(BeneficiaryResponse.builder().beneficiaryId("1").build())
            .paymentType("TRANSFER")
            .account(BigDecimal.valueOf(1234))
            .build();
    PaymentEntity paymentsEntityResponse =
        PaymentEntity.builder()
            .paymentId(12L)
            .paymentType("TRANFER")
            .customer(
                CustomerEntity.builder()
                    .customerId("1")
                    .documentType("DNI")
                    .documentNumber("123456")
                    .name("JUAN")
                    .surname("GARCIA")
                    .country("ESP")
                    .telephone(12345)
                    .build())
            .beneficiary(BeneficiaryEntity.builder().beneficiaryId("1").build())
            .build();

    when(paymentRepository.existsById(anyLong())).thenReturn(true);
    when(customerRepository.findById(anyString()))
        .thenReturn(Optional.of(CustomerEntity.builder().build()));
    when(beneficiaryRepository.findById(anyString()))
        .thenReturn(Optional.of(BeneficiaryEntity.builder().build()));
    when(paymentRepository.save(any(PaymentEntity.class))).thenReturn(paymentsEntityResponse);

    var result =
        updatePaymentService.updatePayment(
            PaymentRequest.builder().paymentId(12L).beneficiaryId("12").customerId("12").build());
    assertEquals(expectedPaymentsResponse.getPaymentId(), result.getPaymentId());
    assertEquals(
        expectedPaymentsResponse.getCustomer().getCustomerId(),
        result.getCustomer().getCustomerId());
    assertEquals(
        expectedPaymentsResponse.getBeneficiary().getBeneficiaryId(),
        result.getBeneficiary().getBeneficiaryId());
  }

  @Test
  void shouldThrowNotFoundWhenPaymentIdDoesNotExists() {
    when(paymentRepository.existsById(anyLong())).thenReturn(false);
    assertThrows(
        PaymentNotFoundException.class,
        () -> updatePaymentService.updatePayment(PaymentRequest.builder().paymentId(12L).build()));
  }

  @Test
  void shouldThrowNotFoundWhenCustomerIdDoesNotExists() {
    when(paymentRepository.existsById(anyLong())).thenReturn(true);
    assertThrows(
        CustomerNotFoundException.class,
        () -> updatePaymentService.updatePayment(PaymentRequest.builder().paymentId(12L).build()));
  }

  @Test
  void shouldThrowNotFoundWhenBeneficiaryIdDoesNotExists() {
    when(paymentRepository.existsById(anyLong())).thenReturn(true);
    when(customerRepository.findById(anyString()))
            .thenReturn(Optional.of(CustomerEntity.builder().build()));
    assertThrows(
            BeneficiaryNotFoundException.class,
            () -> updatePaymentService.updatePayment(PaymentRequest.builder().paymentId(12L).customerId("12").build()));
  }
}
