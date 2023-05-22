package com.capgemini.training.api.service;

import com.capgemini.training.api.exceptions.BeneficiaryNotFoundException;
import com.capgemini.training.api.repository.BeneficiaryRepository;
import com.capgemini.training.api.repository.model.BeneficiaryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BeneficiaryDetailsService {
    private final BeneficiaryRepository repository;

    public List<BeneficiaryEntity> findAll() {
        return repository.findAll();
    }

    public BeneficiaryEntity findById(String id) {
        return repository.findById(id).orElseThrow(BeneficiaryNotFoundException::new);
    }
}
