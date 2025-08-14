package com.capgemini.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.training.api.service.BookDetailsService;

@SpringBootApplication
public class TrainingApplication implements CommandLineRunner {

    @Autowired
    BookDetailsService service;

    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.testDuoDigit();

        ;
    }

}
