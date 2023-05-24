package com.capgemini.training.api.controller;

import com.capgemini.training.api.exceptions.PaymentBadRequestException;
import com.capgemini.training.api.exceptions.PaymentNotFoundException;
import com.capgemini.training.api.model.PaymentDetails;

import com.capgemini.training.api.repository.model.PaymentEntity;
import com.capgemini.training.api.service.NewPaymentDetailsService;

import com.capgemini.training.api.service.mapper.PaymentMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Optional;



/*
 @Test
  public void shouldCreateNewCustomerWhenRequestIsValid() {

    doReturn(CustomerDetailsMother.init().getCustomerEntity()).when(repository).save(
        ArgumentMatchers.any(CustomerEntity.class));
    CustomerDetails newCustomer = this.service.createNewCustomer(
        CustomerDetailsMother.init().getCustomerDetails());
    verify(this.repository).save(ArgumentMatchers.any(CustomerEntity.class));
    assertThat(newCustomer).isNotNull();
    assertThat(newCustomer.getName()).isEqualTo("Mark");
    assertThat(newCustomer.getLastName()).isEqualTo("fernandez");
  }
 */
class NewPaymentDetailsControllerTest {

    @Mock
    private NewPaymentDetailsService paymentService;

    @InjectMocks
    private NewPaymentDetailsController paymentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 @Test
    @DisplayName("Should return new Payment with HTTP status OK")
    void testNewPaymentSuccess() {
        // given
        PaymentDetails paymentDetails =PaymentDetailsMother.init().getPaymentDetails();

        Mockito.when(paymentService.createNewPayment( paymentDetails)).thenReturn(paymentDetails);

        // when
        ResponseEntity<PaymentDetails> response = paymentController.createNewPayment( paymentDetails );

        // then
        assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(paymentDetails, response.getBody());
        verify(paymentService).createNewPayment(any());
    }

    @Test
    @DisplayName("Should throw PaymentBadRequestException when creating invalid Payment")
    void testNewPaymentInvalid() {

        PaymentDetails paymentDetails =PaymentDetailsMother.init().getPaymentDetails();

        doThrow( new PaymentBadRequestException("Incorrect payment ")).when(this.paymentService)
                .createNewPayment(paymentDetails);

        Assertions.assertThrows(PaymentBadRequestException.class,
                () -> this.paymentController.createNewPayment(paymentDetails));

    }
}
