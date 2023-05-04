package com.capgemini.training.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "customer")
public class CustomerEntity {

  @Id
  @Column(length = 10, nullable = false)
  private String customerId;

  @Column(length = 8, nullable = false)
  private String documentType;

  @Column(length = 50, nullable = false)
  private String documentNumber;

  @Column(length = 100, nullable = false)
  private String name;

  @Column(length = 100, nullable = false)
  private String surname;

  @Column(length = 100)
  private String lastname;

  @Column(length = 3, nullable = false)
  private String country;

  @Column private Integer telephone;

  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date updateDate;
}
