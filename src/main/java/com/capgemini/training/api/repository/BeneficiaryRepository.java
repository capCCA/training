package com.capgemini.training.api.repository;

import com.capgemini.training.api.repository.model.BeneficiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiaryEntity, String> {

}
