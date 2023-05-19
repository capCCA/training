package com.capgemini.training.repository;

import com.capgemini.training.entity.BeneficiaryEntity;
import com.capgemini.training.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiaryEntity, String> {


}