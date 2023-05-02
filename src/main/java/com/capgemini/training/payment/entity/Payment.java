package com.capgemini.training.payment.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue
    @Column(name = "Payment_id", nullable = false)
    private Long paymentId;

    @Column(name = "Customer_id", nullable = false)
    private String customerId;

    @Column(name = "Beneficiary_id", nullable = false)
    private String beneficiaryId;

    @Column(name = "Payment_type", nullable = false)
    private String paymentType;

    @Column(name = "Amount", nullable = false)
    private String amount;

    @Column(name = "Creation_date", nullable = false)
    Timestamp creationDate;

    @Column(name = "Update_date")
    Timestamp updateDate;
}
