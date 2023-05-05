package com.capgemini.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
