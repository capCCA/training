package com.capgemini.training.config;

import com.capgemini.training.dto.BeneficiaryDto;
import com.capgemini.training.entity.Beneficiary;
import lombok.experimental.UtilityClass;

@UtilityClass
public  class BeneficiaryMapper {
    public Beneficiary toEntity(BeneficiaryDto dto) {
        return Beneficiary.builder().beneficiaryId(dto.getBeneficiaryId()).build();
    }

    public BeneficiaryDto toDto(Beneficiary beneficiary) {
        return BeneficiaryDto.builder().beneficiaryId(beneficiary.getBeneficiaryId()).build();
    }
}