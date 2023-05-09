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

  @Column(nullable = false, length = 10)
  private String customerId;

  @Column(nullable = false, length = 10)
  private String beneficiaryId;

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
