package com.capgemini.training.api.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.api.model.BookDetails;
import com.capgemini.training.api.service.BookDetailsService;
import com.capgemini.training.api.service.mapper.BookMapper;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

//@Tag(name = "PaymentEntity", description = "API of PaymentGetController")
@Tag(name = "BookEntity", description = "API of BookDetailsController")

@RestController
//@RequestMapping(path = "www.googleapis.com/books/v1/volumes")
@RequestMapping(path = "books/v1/volumes")
@RequiredArgsConstructor
@Transactional
public class BookDetailsController {

    public final BookDetailsService service;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("BookDetailsController");
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDetails>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(BookMapper::toDto).toList());
    }

//  @GetMapping()
//  public ResponseEntity<List<BookDetails>> findByName(@RequestParam("q") String bookName) {
//      return ResponseEntity.ok(service.findByName(bookName).stream().map(BookMapper::toDto).toList());
//  }


      @GetMapping()
      public ResponseEntity<List<BookDetails>>  findByNameAndSizeOld(
              @RequestParam("q") String bookName,
              @RequestParam("startIndex", required = false) int startIndex,
              @RequestParam("maxResults", required = false) int maxResults) {
        return ResponseEntity.ok(
                    service.findByNameAndSize(bookName, startIndex, maxResults)
                            .stream().map(BookMapper::toDto).toList());
    }

    @GetMapping()
    public ResponseEntity<List<BookDetails>> findByNameAndSize(
            @RequestParam(value = "q", required = false) String bookName,
            @RequestParam(value = "startIndex", required = false) Integer startIndex,
            @RequestParam(value = "maxResults", required = false) Integer maxResults) {
        if ((maxResults == null || startIndex == null))
            return ResponseEntity.ok(
                    service.findByName(bookName).stream().map(BookMapper::toDto).toList());
        return ResponseEntity.ok(
                service.findByNameAndSize(bookName, startIndex, maxResults).stream().map(BookMapper::toDto).toList());
    }

}
