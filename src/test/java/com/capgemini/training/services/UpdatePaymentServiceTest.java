package com.capgemini.training.services;

import com.capgemini.training.repositories.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdatePaymentServiceTest {

  @InjectMocks private UpdatePaymentService updatePaymentService;
  @Mock private PaymentRepository paymentRepository;
}
