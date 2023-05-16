package com.capgemini.training.repository.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name="payment_id", nullable = false)
    private Long paymentId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "beneficiary_id")
    Beneficiary beneficiary;
    @Column(name="payment_type", nullable = false)
    private String paymentType;
    @Column(name="amount", nullable = false)
    private BigDecimal amount;
    @Column(name="creation_date", nullable = false)
    private LocalDate creationDate;
    @Column(name="update_date")
    private LocalDate updateDate;

}


