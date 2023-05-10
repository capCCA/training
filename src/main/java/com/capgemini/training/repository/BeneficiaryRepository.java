package com.capgemini.training.repository;

import com.capgemini.training.entity.BeneficiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiaryEntity, String> {

}
