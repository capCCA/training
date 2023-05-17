package com.capgemini.training.api.service.mapper;

import com.capgemini.training.api.model.BeneficiaryDetails;
import com.capgemini.training.api.repository.model.BeneficiaryEntity;
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