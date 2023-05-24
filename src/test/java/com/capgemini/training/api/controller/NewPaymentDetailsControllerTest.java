package com.capgemini.training.api.controller;

import com.capgemini.training.api.model.PaymentDetails;
import com.capgemini.training.api.repository.model.BeneficiaryEntity;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.repository.model.PaymentEntity;
import com.capgemini.training.api.service.PaymentDetailsService;
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

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.time.ZoneOffset.UTC;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;


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
    private PaymentDetailsService paymentService;

    @InjectMocks
    private PaymentDetailsController paymentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    public PaymentEntity createPayment(Long id, String type, String customerId) {
        return PaymentEntity.builder().paymentId(id).customer(createUser(customerId))
                .beneficiary(createBeneficiary("23456")).paymentType(type).amount(BigDecimal.valueOf(2000333))
                .creationDate(ZonedDateTime.now(UTC)).build();
    }

    public CustomerEntity createUser(String id) {
        //CustomerDetailsMother.init().getCustomerEntity();
        return CustomerEntity.builder().customerId(id).documentType("dni").documentNumber("123" + id).name("john" + id)
                .surname("green" + id).lastname("junior" + id).country("ESP").telephone(123)
                .creationDate(ZonedDateTime.now(UTC)).build();
    }

    public BeneficiaryEntity createBeneficiary(String id) {
        return BeneficiaryEntity.builder().beneficiaryId(id).build();
    }

    @Test
    @DisplayName("Should return a list of all payments when no customerId provided with HTTP status OK")
    void testGetAllPayments() {
        // given
        List<PaymentEntity> payments = new ArrayList<>();
        payments.add(PaymentDetailsMother.init().getPaymentEntity());
        payments.add(PaymentDetailsMother.init().getPaymentEntity());

        Mockito.when(paymentService.findAll()).thenReturn(payments);

        // when
        ResponseEntity<List<PaymentDetails>> response = paymentController.findByCustomerId(null);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(2, response.getBody().size());
    }

    @Test
    @DisplayName("Should return empty list of payments when customer Id Not found, with HTTP status OK")
    void testReturnEmptyListByCustomerIdNotfound() {
        // given
        Mockito.when(paymentService.findByCustomerId(anyString())).thenReturn( List.of());

        // when
        ResponseEntity<List<PaymentDetails>> response = paymentController.findByCustomerId("12345");

        // then
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(0, response.getBody().size());
    }
    @Test
    @DisplayName("Should return the payments by customer Id Valid, with HTTP status OK")
    void testGetPaymentsByCustomerIdValid() {
        // given
        List<PaymentEntity> payments = new ArrayList<>();
        payments.add(PaymentDetailsMother.init().getPaymentEntity());
        payments.add(PaymentDetailsMother.init().getPaymentEntity());

        String customerId = payments.get(0).getCustomer().getCustomerId();

        Mockito.when(paymentService.findByCustomerId(customerId)).thenReturn(payments.stream().limit(2).toList());

        // when
        ResponseEntity<List<PaymentDetails>> response = paymentController.findByCustomerId(customerId);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(2, response.getBody().size());
    }
    @Test
    @DisplayName("Should return a PaymentEntity give valid payment Id , with HTTP status OK")
    void testGetPaymentByIdValid() {
        // given

        PaymentEntity expectedPayment = PaymentDetailsMother.init().getPaymentEntity();
        Long id =expectedPayment.getPaymentId();

       Mockito.when(paymentService.findById(id)).thenReturn(Optional.of(expectedPayment));

        // when
        ResponseEntity<PaymentDetails> response = paymentController.findById(id);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        PaymentDetails expectedPaymentDetails = PaymentMapper.toDto(expectedPayment);

        Assertions.assertEquals(expectedPaymentDetails, response.getBody());
    }

    @Test
    @DisplayName("Should return HTTP status NOT_FOUND when PaymentEntity NOt FOUND")
    void testGetPaymentByIdNotFound() {
        // given
        Long id = 13L;

        Mockito.when(paymentService.findById(anyLong())).thenReturn(Optional.empty());

        // when
        ResponseEntity<PaymentDetails> response = paymentController.findById(id);

        // then
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
