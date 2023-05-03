package com.capgemini.training.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.user.entity.User;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {

}
