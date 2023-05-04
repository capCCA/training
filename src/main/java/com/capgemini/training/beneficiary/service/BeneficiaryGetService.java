package com.capgemini.training.beneficiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.training.beneficiary.entity.Beneficiary;
import com.capgemini.training.beneficiary.repository.BeneficiaryRepository;

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
