package com.capgemini.training.config;

import com.capgemini.training.dto.BeneficiaryDetails;
import com.capgemini.training.entity.BeneficiaryEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public  class BeneficiaryMapper {
    public BeneficiaryEntity toEntity(BeneficiaryDetails dto) {
        return BeneficiaryEntity.builder().beneficiaryId(dto.getBeneficiaryId()).build();
    }

    public BeneficiaryDetails toDto(BeneficiaryEntity beneficiary) {
        return BeneficiaryDetails.builder().beneficiaryId(beneficiary.getBeneficiaryId()).build();
    }
}