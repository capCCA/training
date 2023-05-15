package com.capgemini.training.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.api.repository.model.Greeting;
import com.capgemini.training.api.service.GreetingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/hello")
@RequiredArgsConstructor
public class GreetingController {
  private final GreetingService service;

  /**
   * Method that returns a basic greeting
   *
   * @return {@link Greeting}
   */
  @GetMapping(path = "")
  public ResponseEntity<String> getGreeting() {
    return ResponseEntity.ok(service.getGreeting());
  }

  /**
   * Method that returns a greeting if the user is given
   *
   * @param user
   * @return {@link Greeting}
   */
  @GetMapping("/{user}")
  public ResponseEntity<String> getGreeting(@PathVariable(name = "user") String user) {
    return ResponseEntity.ok(service.getGreeting(user));
  }
}
