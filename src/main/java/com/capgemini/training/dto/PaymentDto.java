package com.capgemini.training.dto;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class PaymentDto {
  private Long paymentId;
  private UserDto customerDto;
  private BeneficiaryDto beneficiaryDto;

  private String paymentType;
  private BigDecimal amount;
}
