package com.capgemini.training.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.user.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, String> {

}
