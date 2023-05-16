package com.capgemini.training.repository.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @Column(name="payment_id", nullable = false)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn(name = "beneficiary_id")
    private BeneficiaryEntity beneficiaryEntity;

    @Column(name="payment_type", nullable = false)
    private String paymentType;
    @Column(name="amount", nullable = false)
    private BigDecimal amount;
    @Column(name="creation_date", nullable = false)
    private LocalDate creationDate;
    @Column(name="update_date")
    private LocalDate updateDate;

}


