package com.capgemini.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.Payment;
import com.capgemini.training.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentGetService {
    private final PaymentRepository repository;

    public List<Payment> findAll() {

        return repository.findAll();
    }

    public Payment findById(Long id) {
        // TODO Auto-generated method stub
        return repository.findById(id).orElse(null);
    }

}
