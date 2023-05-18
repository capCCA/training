package com.capgemini.training.services;

import com.capgemini.training.exceptions.PaymentNotFoundException;
import com.capgemini.training.mappers.PaymentMapper;
import com.capgemini.training.models.PaymentDetailsResponse;
import com.capgemini.training.repository.PaymentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class getCustomerPaymentsDetailsService {

  private final PaymentRepository paymentRepository;
  private final PaymentMapper paymentMapper;

  public List<PaymentDetailsResponse> getCustomerPaymentsDetails(Long customerId) {

    if (paymentRepository.existsById(customerId)) {
      return paymentRepository.findById(customerId).stream()
          .map(paymentMapper::toPaymentDetailsResponse)
          .toList();
    }
    throw new PaymentNotFoundException("El cliente con ID seleccionado no tiene pagos");
  }
}
