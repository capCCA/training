package com.capgemini.training.beneficiary.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class BeneficiaryDto {
    private String beneficiaryId;
    private Timestamp creationDate;
    private Timestamp updateDate;

}
