package com.capgemini.training.repositories;

import com.capgemini.training.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {}
