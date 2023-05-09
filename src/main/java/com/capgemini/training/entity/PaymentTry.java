package com.capgemini.training.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
// ------------------ problem with :
// -----------Caused by: org.hibernate.tool.schema.spi.SchemaManagementException:
// ----------Schema-validation: missing column [payment_beneficiary_fk] in table [payment]
// @Entity
// @Table(name = "payment")
public class PaymentTry {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false)
  private Long paymentId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payment_customer_fk")
  private User customer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payment_beneficiary_fk")
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
