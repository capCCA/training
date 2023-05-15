package com.capgemini.training.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.training.api.repository.model.BeneficiaryEntity;
import com.capgemini.training.api.repository.BeneficiaryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeneficiaryDetailsService {
    private final BeneficiaryRepository repository;

    public List<BeneficiaryEntity> findAll() {
        return repository.findAll();
    }

    public BeneficiaryEntity findById(String id) {
        return repository.findById(id).orElse(null);
    }
}
