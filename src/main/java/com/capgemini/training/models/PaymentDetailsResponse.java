package com.capgemini.training.models;

import com.capgemini.training.repository.models.BeneficiaryEntity;
import com.capgemini.training.repository.models.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsResponse {

  @NotNull private Long paymentId;

  @NotNull
  @Size(max = 10)
  private CustomerEntity customer;

  @NotNull
  @Size(max = 10)
  private BeneficiaryEntity beneficiary;

  @NotNull
  @Size(max = 10)
  private String paymentType;

  @NotNull private BigDecimal amount;

  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate creationDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate updateDate;
}
