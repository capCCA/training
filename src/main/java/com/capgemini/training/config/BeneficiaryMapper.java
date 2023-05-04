package com.capgemini.training.config;

import com.capgemini.training.beneficiary.dto.BeneficiaryDto;
import com.capgemini.training.beneficiary.entity.Beneficiary;

public final class BeneficiaryMapper {
    public static Beneficiary toEntity(BeneficiaryDto dto) {
        return Beneficiary.builder().beneficiaryId(dto.getBeneficiaryId()).build();
    }

    public static BeneficiaryDto toDto(Beneficiary beneficiary) {
        return BeneficiaryDto.builder().beneficiaryId(beneficiary.getBeneficiaryId()).build();
    }
}