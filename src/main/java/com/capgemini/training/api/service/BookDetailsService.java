package com.capgemini.training.api.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.capgemini.training.api.repository.BookRepository;
import com.capgemini.training.api.repository.model.BookEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Service
@RequiredArgsConstructor
@Log
public class BookDetailsService {
    private final BookRepository repository;

    @Transactional
    public List<BookEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Optional<BookEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public List<BookEntity> findByName(String name) {
        return repository.findAll().stream().filter(c -> c.getName().equals(name)).toList();

    }

    @Transactional
    public List<BookEntity> findByNameAndSize(String name, Integer startIndex, Integer maxResults) {
        List<BookEntity> books = null;
        if (name != null)
            books = repository.findAll().stream().filter(c -> c.getName().equals(name)).toList();
        else
            books = repository.findAll();

        List<BookEntity> booksToReturn = new ArrayList<BookEntity>();

        int numBooks = 0;
        for (int i = startIndex; i < books.size(); i++) {
            numBooks++;
            if (numBooks <= maxResults)
                booksToReturn.add(books.get(i));
        }
        return booksToReturn;
    }

    /**
     * Checks if a number is a duodigit.
     * 
     * @param {number} num
     * @returns {boolean}
     */
    public void testDuoDigit() {
        log.info(" isDuoDigit(112) " + isDuoDigit(112));
        log.info(" isDuoDigit(-112) " + isDuoDigit(-112));
        log.info(" isDuoDigit(2022) " + isDuoDigit(2022));
        log.info(" isDuoDigit(99999999)" + isDuoDigit(99999999));

        log.info(" isDuoDigit(1234) " + isDuoDigit(1234));
        log.info(" isDuoDigit(2023) " + isDuoDigit(2023));

    }

    private boolean isDuoDigit(Integer num) {
        num = Math.abs(num); // -112
        String digitStr = num.toString(); // 112
        Set digitSet = new HashSet(); // 12
        for (int i = 0; i < digitStr.length(); i++) {
            digitSet.add(digitStr.charAt(i));
        }
        log.info("this is digitSet: " + digitSet.toString());
        // return new Set(Math.abs(num).toString()).size <= 2;
        return digitSet.size() <= 2;
    }

    private boolean isDuoDigitTest_(Integer num) {
        num = Math.abs(num); // -112
        // String digitStr = num.toString(); // 112
        String digitStr = String.valueOf(num.intValue());
        // String [] digitStrAr= String.valueOf(num.intValue()).split("");
        Set digitSet = new HashSet(); // 12
        for (int i = 0; i < digitStr.length(); i++) {
            digitSet.add(digitStr.charAt(i));
        }
        log.info("this is digitSet: " + digitSet.toString());
        // return new Set(Math.abs(num).toString()).size <= 2;
        return digitSet.size() <= 2;
    }

}
