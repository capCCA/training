package com.capgemini.training.entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Greeting {
  private String msg = "Hello ";
}
