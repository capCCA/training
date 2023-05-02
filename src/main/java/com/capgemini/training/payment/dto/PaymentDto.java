package com.capgemini.training.payment.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class PaymentDto {
    private Long paymentId;
    private String customerId;
    private String beneficiaryId;
    private String paymentType;
    private String amount;
    Timestamp creationDate;
    Timestamp updateDate;
}
