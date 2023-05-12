package com.capgemini.training.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
  BIZUM("BIZUM"),
  TRANSFER("TRANSFER");

  private final String value;
}
