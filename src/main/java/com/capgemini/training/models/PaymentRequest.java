package com.capgemini.training.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaymentRequest {

  private static final String NOTNULL_MESSAGE = "is mandatory, should be present";

  private Long paymentId;

  @NotBlank(message = NOTNULL_MESSAGE)
  private String customerId;

  @NotBlank(message = NOTNULL_MESSAGE)
  private String beneficiaryId;

  @NotBlank(message = NOTNULL_MESSAGE)
  private String paymentType;

  @NotNull(message = NOTNULL_MESSAGE)
  private BigDecimal account;

  private LocalDateTime creationDate;
  private LocalDateTime updateDate;
}
