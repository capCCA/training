package com.capgemini.training.api.service;

import com.capgemini.training.api.controller.PaymentDetailsMother;
import com.capgemini.training.api.exceptions.PaymentNotFoundException;
import com.capgemini.training.api.repository.PaymentRepository;
import com.capgemini.training.api.repository.model.PaymentEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NewPaymentDetailsServiceTest {

    @Mock
    private PaymentRepository repository;

    @InjectMocks
    private PaymentDetailsService service;


    @Test
    public void shouldReturnPaymentWithPaymentIdValid() {

        PaymentEntity expectedPaymentEntity = PaymentDetailsMother.init().getPaymentEntity();
        Long expectedPaymentId = expectedPaymentEntity.getPaymentId();

        doReturn(Optional.of(expectedPaymentEntity)).when(this.repository)
                .findById(anyLong());

        PaymentEntity paymentEntity = service.findById(expectedPaymentId).get();
        assertThat(paymentEntity).isNotNull();
        assertThat(paymentEntity.getPaymentType()).isEqualTo("transfer");
        assertThat(paymentEntity.getAmount()).isEqualTo(BigDecimal.valueOf(1210));
        verify(this.repository).findById(anyLong());
    }

    @Test
    public void shouldReturnPaymentListWhenCustomerIdValid() {
        List<PaymentEntity> payments = new ArrayList<>();
        payments.add(PaymentDetailsMother.init().getPaymentEntity());
        payments.add(PaymentDetailsMother.init().getPaymentEntity());

        String customerId = payments.get(0).getCustomer().getCustomerId();

        //Mockito.when(this.repository.findAllByCustomerCustomerId(customerId)).thenReturn(payments.stream().limit(1).toList());
        doReturn(payments.stream().limit(1).toList()).when( this.repository).findAllByCustomerCustomerId(customerId);
        // when
        List<PaymentEntity> actualPayments = service.findByCustomerId(customerId);

        // then
        assertThat(1).isEqualTo(actualPayments.size());
        assertThat(actualPayments.get(0).getPaymentType()).isEqualTo("transfer");
        assertThat(actualPayments.get(0).getAmount()).isEqualTo(BigDecimal.valueOf(1210));

    }

    @Test
    public void shouldReturnEmptyListWhenCustomerIdNotFound() {

        //Mockito.when(repository.findAllByCustomerCustomerId(anyString())).thenReturn(List.of());
        doReturn(List.of()).when(this.repository).findAllByCustomerCustomerId( anyString());

        // when
        List<PaymentEntity> actualPayments = service.findByCustomerId("1234");

        // then
        assertThat(0).isEqualTo(actualPayments.size());
    }


    @Test
    public void shouldReturnAllPayments() {
        PaymentEntity expectedPaymentEntity = PaymentDetailsMother.init().getPaymentEntity();

        doReturn(List.of(PaymentDetailsMother.init().getPaymentEntity(),
                PaymentDetailsMother.init().getPaymentEntity())).when(this.repository)
                .findAll();

        List<PaymentEntity> actualPayments = service.findAll();
        assertThat(actualPayments).isEqualTo(2);
        verify(this.repository).findAll();
    }


    public void _shouldReturnExceptionWhenPaymentIdIsNull() {
        Assertions.assertThrows(PaymentNotFoundException.class,
                () -> this.service.findById(null));
    }


    public void _shouldReturnExceptionWhenPaymentIdNotFound() {
        doReturn(Optional.ofNullable(null)).when(this.repository)
                .findById(anyLong());
        Assertions.assertThrows(PaymentNotFoundException.class,
                () -> this.service.findById(12L));
    }


}