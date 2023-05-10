package com.capgemini.training.repositories.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
  BIZUM("BIZUM"),
  TRANSFER("TRANSFER");

  private String value;
}
