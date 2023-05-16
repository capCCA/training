package com.capgemini.training.repository;

import com.capgemini.training.repository.models.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {

}
