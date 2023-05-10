package com.capgemini.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.entity.BeneficiaryEntity;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiaryEntity, String> {

}