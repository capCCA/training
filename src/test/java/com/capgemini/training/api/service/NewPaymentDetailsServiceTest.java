package com.capgemini.training.api.service;

import com.capgemini.training.api.controller.BeneficiaryDetailsMother;
import com.capgemini.training.api.controller.CustomerDetailsMother;
import com.capgemini.training.api.controller.PaymentDetailsMother;
import com.capgemini.training.api.exceptions.BeneficiaryBadRequestException;
import com.capgemini.training.api.exceptions.BeneficiaryNotFoundException;
import com.capgemini.training.api.exceptions.CustomerNotFoundException;
import com.capgemini.training.api.exceptions.PaymentBadRequestException;
import com.capgemini.training.api.model.PaymentDetails;
import com.capgemini.training.api.repository.BeneficiaryRepository;
import com.capgemini.training.api.repository.CustomerRepository;
import com.capgemini.training.api.repository.PaymentRepository;
import com.capgemini.training.api.repository.model.PaymentEntity;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.repository.model.BeneficiaryEntity;
import com.capgemini.training.api.service.mapper.PaymentMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class NewPaymentDetailsServiceTest {


    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private CustomerDetailsService customerService;
    @Mock
    private BeneficiaryDetailsService beneficiaryService;


    @InjectMocks
    private NewPaymentDetailsService paymentService;


    @Test
    void createNewPaymentSuccess() {

         PaymentEntity paymentEntity =PaymentDetailsMother.init().getPaymentEntity();
         CustomerEntity custEntity= CustomerDetailsMother.init().getCustomerEntity();
         BeneficiaryEntity benEntity= BeneficiaryDetailsMother.init().getBeneficiaryEntity();

        //new payment does not exist then it will be created
        when(paymentRepository.existsById(any())).thenReturn(false);
        when(customerService.findById(any())).thenReturn(custEntity);//dont throw
        when(beneficiaryService.findById(any())).thenReturn(benEntity);//dont throw

        when(paymentRepository.save(any(PaymentEntity.class))).thenReturn(paymentEntity);
        PaymentDetails expectedPaymentDetails = PaymentMapper.toDto( paymentEntity);

        PaymentDetails actualPaymentDetails = paymentService.createNewPayment(expectedPaymentDetails);

        //assertEquals(Optional.of(customerEntity), customerRepository.findById(any()));
        assertNotNull(actualPaymentDetails);
        verify(paymentRepository).save(any(PaymentEntity.class));
    }

    @Test
    void createNewPaymentBeneficiaryNotFoundException() {
        PaymentDetails expectedPaymentDetails =PaymentDetailsMother.init().getPaymentDetails();
        CustomerEntity custEntity= CustomerDetailsMother.init().getCustomerEntity();
       // BeneficiaryEntity benEntity= BeneficiaryDetailsMother.init().getBeneficiaryEntity();
        PaymentEntity ent = PaymentMapper.toEntity( expectedPaymentDetails);

        when(customerService.findById(any())).thenReturn(custEntity);//dont throw
        when(beneficiaryService.findById(any())).thenThrow( new BeneficiaryNotFoundException());
        when(paymentRepository.save(any(PaymentEntity.class))).thenReturn(ent);//ent

        assertThatThrownBy(() -> paymentService.createNewPayment(expectedPaymentDetails))
                .isInstanceOf(BeneficiaryNotFoundException.class);
                //.hasMessage("..");

    }
    @Test
    void createNewPaymentCustomerNotFoundException() {
        PaymentDetails expectedPaymentDetails =PaymentDetailsMother.init().getPaymentDetails();
        PaymentEntity ent =PaymentDetailsMother.init().getPaymentEntity();
//        CustomerEntity custEntity= CustomerDetailsMother.init().getCustomerEntity();
        BeneficiaryEntity benEntity= BeneficiaryDetailsMother.init().getBeneficiaryEntity();

        when(beneficiaryService.findById(anyString())).thenReturn(benEntity);//dont throw
        when(customerService.findById(anyString())).thenThrow( new CustomerNotFoundException()) ;

        when(paymentRepository.save(any(PaymentEntity.class))).thenReturn(ent);

        assertThrows(
                CustomerNotFoundException.class, () -> paymentService.createNewPayment(expectedPaymentDetails));

    }

}