package com.capgemini.training.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.capgemini.training.entity.PaymentEntity;
import org.springframework.stereotype.Service;

import com.capgemini.training.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentDetailsService {
    private final PaymentRepository repository;

    @Transactional
    public List<PaymentEntity> findAll() {
        return repository.findAll();
    }

    public Optional<PaymentEntity> findById(Long id) {
        return repository.findById(id);
    }

//  public PaymentEntity findById(Long id) {
//    return repository.findById(id).orElse(null);
//  }
}
