package com.capgemini.training.payment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Payment_id", nullable = false)
    private Long paymentId;

    @Column(name = "Customer_id", nullable = false, length = 10)
    private String customerId;

    @Column(name = "Beneficiary_id", nullable = false, length = 10)
    private String beneficiaryId;

    @Column(name = "Payment_type", nullable = false)
    private String paymentType;

    @Column(name = "Amount", nullable = false)
    private String amount;

    @Column(name = "Creation_date", nullable = false)
    Date creationDate;

    @Column(name = "Update_date")
    Date updateDate;
}
