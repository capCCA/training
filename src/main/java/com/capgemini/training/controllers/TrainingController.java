package com.capgemini.training.controllers;

import com.capgemini.training.services.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/hello"})
@RequiredArgsConstructor
public class TrainingController {

  private final TrainingService service;

  @GetMapping
  public String getHello() {
    return service.getHello();
  }
}
