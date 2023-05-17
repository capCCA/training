package com.capgemini.training.repository;

import com.capgemini.training.repository.models.BeneficiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepository extends JpaRepository<BeneficiaryEntity,String> {

        }
