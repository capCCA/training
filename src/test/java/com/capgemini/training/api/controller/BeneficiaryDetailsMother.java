package com.capgemini.training.api.controller;

import com.capgemini.training.api.model.BeneficiaryDetails;
import com.capgemini.training.api.repository.model.BeneficiaryEntity;

import java.util.UUID;

public class BeneficiaryDetailsMother {

    private String beneficiaryId;

    public BeneficiaryDetailsMother() {
        this.beneficiaryId = UUID.randomUUID().toString();

    }

    public static BeneficiaryDetailsMother init() {
        return new BeneficiaryDetailsMother();
    }


    public BeneficiaryDetailsMother withBeneficiaryId(String benId) {
        this.beneficiaryId = benId;
        return this;
    }

    public BeneficiaryDetails getBeneficiaryDetails() {
        BeneficiaryDetails benDetails = BeneficiaryDetails.builder().build();
        benDetails.setBeneficiaryId(this.beneficiaryId);

        return benDetails;
    }

    public BeneficiaryEntity getBeneficiaryEntity() {
        BeneficiaryEntity customerDetails = BeneficiaryEntity.builder().build();
        customerDetails.setBeneficiaryId(this.beneficiaryId);

        return customerDetails;
    }
}
