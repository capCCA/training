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
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long paymentId;

    @Column(nullable = false, length = 10)
    private String customerId;

    @Column(nullable = false, length = 10)
    private String beneficiaryId;

    @Column(nullable = false)
    private String paymentType;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    Date creationDate;

    @Column
    Date updateDate;
}
