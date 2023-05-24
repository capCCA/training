package com.capgemini.training.api.controller;

import com.capgemini.training.api.model.BeneficiaryDetails;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.model.PaymentDetails;
import com.capgemini.training.api.model.UpdatePaymentRequest;
import com.capgemini.training.api.repository.model.PaymentEntity;

import java.math.BigDecimal;
import java.util.Random;

public class PaymentDetailsMother {

    private Long paymentId;
    private CustomerDetails customerDetails;
    private BeneficiaryDetails beneficiaryDetails;
    private String paymentType;
    private BigDecimal amount;

    public PaymentDetailsMother() {
        this.paymentId = new Random().nextLong();//UUID.randomUUID();
        this.customerDetails = CustomerDetailsMother.init().getCustomerDetails();
        this.beneficiaryDetails = BeneficiaryDetailsMother.init().getBeneficiaryDetails();
        this.paymentType = "transfer";
        this.amount = BigDecimal.valueOf(1210);

    }

    public static PaymentDetailsMother init() {
        return new PaymentDetailsMother();
    }


    public PaymentDetailsMother withCustomer(CustomerDetails customer) {
        this.customerDetails = customer;
        return this;
    }

    public PaymentDetailsMother withBeneficiary(BeneficiaryDetails ben) {
        this.beneficiaryDetails = ben;
        return this;
    }

    public PaymentDetailsMother withPaymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public PaymentDetailsMother withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public PaymentDetails getPaymentDetails() {
        PaymentDetails paymentDetails = PaymentDetails.builder().build();
        paymentDetails.setPaymentId(this.paymentId);
        paymentDetails.setPaymentType(this.paymentType);
        paymentDetails.setAmount(this.amount);
        paymentDetails.setCustomerDetails(this.customerDetails);
        paymentDetails.setBeneficiaryDetails(this.beneficiaryDetails);
        return paymentDetails;
    }


    public UpdatePaymentRequest getUpdatePayment() {
        UpdatePaymentRequest paymentDetails = UpdatePaymentRequest.builder().build();
        paymentDetails.setPaymentType(this.paymentType);
        paymentDetails.setAmount(this.amount);
        paymentDetails.setCustomerDetails(CustomerDetailsMother.init().getCustomerDetails());
        paymentDetails.setBeneficiaryDetails(BeneficiaryDetailsMother.init().getBeneficiaryDetails());
        return paymentDetails;
    }


    public PaymentEntity getPaymentEntity() {
        PaymentEntity paymentDetails = PaymentEntity.builder().build();
        paymentDetails.setPaymentId(this.paymentId);
        paymentDetails.setPaymentType(this.paymentType);
        paymentDetails.setAmount(this.amount);
        paymentDetails.setCustomer(CustomerDetailsMother.init().getCustomerEntity());
        paymentDetails.setBeneficiary(BeneficiaryDetailsMother.init().getBeneficiaryEntity());
        return paymentDetails;
    }
}
