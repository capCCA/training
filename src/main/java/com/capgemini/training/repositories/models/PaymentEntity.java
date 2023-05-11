package com.capgemini.training.repositories.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "payment")
public class PaymentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(length = 10, nullable = false)
  private Long paymentId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private CustomerEntity customer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "beneficiary_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private BeneficiaryEntity beneficiaryEntity;

  @Column(length = 10, nullable = false)
  private String paymentType;

  @Column(length = 10, nullable = false)
  private BigDecimal account;

  @Column private LocalDateTime creationDate;

  @Column private LocalDateTime updateDate;
}
