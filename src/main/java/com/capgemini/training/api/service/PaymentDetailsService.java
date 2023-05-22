package com.capgemini.training.api.service;

import com.capgemini.training.api.repository.PaymentRepository;
import com.capgemini.training.api.repository.model.PaymentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentDetailsService {
    private final PaymentRepository repository;

    @Transactional
    public List<PaymentEntity> findAll() {
        return repository.findAll();
    }

    public List<PaymentEntity> findByCustomerId(String customerId) {

        return repository.findAllByCustomerCustomerId(customerId);
    }

    public Optional<PaymentEntity> findById(Long id) {
        return repository.findById(id);
    }
}

//-------------
// Notas: otra forma, sin tener que definir en repo findAllByCustomerCustomerId

// public List<PaymentEntity> findByCustomerId(String customerId) {
//        
//        List<PaymentEntity> paymentList = repository.findAll().stream()
//                .filter(p -> p.getCustomer().getCustomerId().equals(customerId))
//                .toList();
//        return paymentList;

//  public PaymentEntity findById(Long id) {
//    return repository.findById(id).orElse(null);
//  }
