package com.capgemini.training.service;

import com.capgemini.training.entity.Payment;
import com.capgemini.training.repository.PaymentRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentGetService {
  private final PaymentRepository repository;

  public List<Payment> findAll() {
    return repository.findAll();
  }

  public Optional<Payment> findById(Long  id) {
    return repository.findById(id);
  }
  
//  public Payment findById(Long id) {
//    return repository.findById(id).orElse(null);
//  }
}
