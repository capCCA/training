package com.capgemini.training.repository.models;

import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class PaymentEntity implements Serializable {

    @Id
    @Column(name="payment_id", nullable = false)
    private Long paymentId;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private CustomerEntity customer;

    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "beneficiary_id")
    private BeneficiaryEntity beneficiary;

    @Column(name="payment_type", nullable = false)
    private String paymentType;

    @Column(name="amount", nullable = false)
    private BigDecimal amount;

    @Column(name="creation_date", nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate creationDate;

    @Column(name="update_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate updateDate;

}


