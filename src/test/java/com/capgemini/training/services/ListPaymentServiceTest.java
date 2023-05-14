package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.BeneficiaryResponse;
import com.capgemini.training.models.CustomerResponse;
import com.capgemini.training.models.PaymentResponse;
import com.capgemini.training.repositories.PaymentRepository;
import com.capgemini.training.repositories.models.BeneficiaryEntity;
import com.capgemini.training.repositories.models.CustomerEntity;
import com.capgemini.training.repositories.models.PaymentEntity;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListPaymentServiceTest {

  @InjectMocks private ListPaymentService listPaymentService;
  @Mock private PaymentRepository paymentRepository;

  @Test
  void getAllPaymentsByCustomerId() {
    List<PaymentResponse> expectedPaymentsResponse =
        List.of(
            PaymentResponse.builder()
                .paymentId(1L)
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
                .build());
    List<PaymentEntity> paymentsEntityResponse =
        List.of(
            PaymentEntity.builder()
                .paymentId(1L)
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
                .build());

    when(paymentRepository.findAllByCustomerCustomerId(anyString()))
        .thenReturn(paymentsEntityResponse);
    var result = listPaymentService.getAllPaymentsByCustomerId("1");
    assertEquals(expectedPaymentsResponse.size(), result.size());
  }

  @Test
  void getAllPayments() {
    List<PaymentResponse> expectedPaymentsResponse =
        List.of(
            PaymentResponse.builder()
                .paymentId(1L)
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
                .build());
    List<PaymentEntity> paymentsEntityResponse =
        List.of(
            PaymentEntity.builder()
                .paymentId(1L)
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
                .build());

    when(paymentRepository.findAll()).thenReturn(paymentsEntityResponse);
    var result = listPaymentService.getAllPayments();
    assertEquals(expectedPaymentsResponse.size(), result.size());
  }
}
