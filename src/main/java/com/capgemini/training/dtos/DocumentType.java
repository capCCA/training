package com.capgemini.training.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentType {
  DNI("DNI"),
  PASSPORT("PASSPORT");

  private String value;
}
