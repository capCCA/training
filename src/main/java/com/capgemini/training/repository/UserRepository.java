/*package com.capgemini.training.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.training.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, String> {

    UserEntity getReferenceById(String customerId);

}*/

package com.capgemini.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}