package com.capgemini.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}