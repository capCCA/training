package com.capgemini.training.repository;

import com.capgemini.training.repository.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {}
