package com.capgemini.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.BeneficiaryEntity;
import com.capgemini.training.repository.BeneficiaryRepository;

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
