package com.capgemini.training.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaymentRequest {
  private Long paymentId;
  private String customerId;
  private String beneficiaryId;
  private String paymentType;
  private BigDecimal account;
  private LocalDateTime creationDate;
  private LocalDateTime updateDate;
}
