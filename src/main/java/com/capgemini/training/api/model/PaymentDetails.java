package com.capgemini.training.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDetails {
  private Long paymentId;
  private CustomerDetails customerDetails;
  private BeneficiaryDetails beneficiaryDto;

  //private PaymentType paymentType;
  private String paymentType;
  private BigDecimal amount;
}
