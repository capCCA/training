package com.capgemini.training.services;

import static org.junit.jupiter.api.Assertions.*;

import com.capgemini.training.repositories.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NewPaymentServiceTest {

  @InjectMocks private NewPaymentService newPaymentService;
  @Mock private PaymentRepository paymentRepository;

  @Test
  void addPayment() {

  }
}
