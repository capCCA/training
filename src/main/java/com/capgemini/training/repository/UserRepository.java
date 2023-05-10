package com.capgemini.training.repository;

import com.capgemini.training.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomerEntity, String> {

}
