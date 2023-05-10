package com.capgemini.training.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private Long paymentId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id") // campo id en Payment, no fk
  private User customer;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "beneficiary_id") //campo id Payment, no fk
  private Beneficiary beneficiary;

  @Column(nullable = false)
  private String paymentType;

  @Column(nullable = false)
  private BigDecimal amount;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  Date creationDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column
  Date updateDate;
}
