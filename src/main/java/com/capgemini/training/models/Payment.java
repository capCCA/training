package com.capgemini.training.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(length = 10, nullable = false)
  private Integer paymentId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_customer")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Customer customer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_beneficiary")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Beneficiary beneficiary;

  @Column(length = 10, nullable = false)
  private PaymentType paymentType;

  @Column(length = 10, nullable = false)
  private String account;

  @Column(nullable = false)
  private Date creationDate;

  private Date updateDate;
}
