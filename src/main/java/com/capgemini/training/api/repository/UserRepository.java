package com.capgemini.training.api.repository;

import com.capgemini.training.api.repository.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomerEntity, String> {

}
