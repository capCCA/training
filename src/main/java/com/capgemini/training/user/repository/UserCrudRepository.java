package com.caggemini.training.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caggemini.training.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
