package com.capgemini.training.api.service.mapper;

import com.capgemini.training.api.model.BookDetails;
import com.capgemini.training.api.repository.model.BookEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BookMapper {

    public BookEntity toEntity(BookDetails dto) {

        return BookEntity.builder().bookId(dto.getBookId()).name(dto.getName()).build();
    }

    public BookDetails toDto(BookEntity book) {

        return BookDetails.builder().bookId(book.getBookId()).name(book.getName()).build();
    }
}
