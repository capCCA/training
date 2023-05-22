package com.capgemini.training.api.repository;

import com.capgemini.training.api.repository.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    List<PaymentEntity> findAllByCustomerCustomerId(String customerId);

}
