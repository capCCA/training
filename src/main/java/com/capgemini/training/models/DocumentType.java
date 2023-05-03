package com.capgemini.training.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum DocumentType {
  DNI("DNI"),
  PASSPORT("PASSPORT");

  private String value;
}
