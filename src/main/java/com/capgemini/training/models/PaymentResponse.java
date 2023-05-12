package com.capgemini.training.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(description = "PaymentDetails")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaymentResponse {
    private Long paymentId;
    private CustomerResponse customer;
    private BeneficiaryResponse beneficiary;
    private String paymentType;
    private BigDecimal account;

}
