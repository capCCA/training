package com.capgemini.training.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerResponse {

  private String customerId;
  private String documentType;
  private String documentNumber;
  private String name;
  private String surname;
  private String country;
}
