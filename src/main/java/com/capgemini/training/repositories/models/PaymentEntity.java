package com.capgemini.training.repositories.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
  @Column(length = 10)
  private Long paymentId;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private CustomerEntity customer;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "beneficiary_id", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonManagedReference
  private BeneficiaryEntity beneficiary;

  @Column(length = 10, nullable = false)
  private String paymentType;

  @Column(length = 10, nullable = false)
  private BigDecimal account;

  @Column private LocalDateTime creationDate;

  @Column private LocalDateTime updateDate;
}
