package com.capgemini.training.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.api.repository.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
