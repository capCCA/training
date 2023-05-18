package com.capgemini.training.services;

import com.capgemini.training.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class getCustomerPaymentsDetailsServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private getCustomerPaymentsDetailsService getCustomerPaymentsDetailsService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getCustomerPaymentsDetailsSuccess() {

      }

    @Test
    void getCustomerPaymentsDetailsNotFound(){
        
    }
}