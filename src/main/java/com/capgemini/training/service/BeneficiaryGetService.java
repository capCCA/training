package com.capgemini.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.Beneficiary;
import com.capgemini.training.repository.BeneficiaryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeneficiaryGetService {
    private final BeneficiaryRepository repository;

    public List<Beneficiary> findAll() {
        return repository.findAll();
    }

    public Beneficiary findById(String id) {
        return repository.findById(id).orElse(null);
    }
}
