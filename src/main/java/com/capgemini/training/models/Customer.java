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

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "customer")
public class Customer {

  @Id
  @Column(name = "customer_id", length = 10, nullable = false)
  private String customerId;

  @Column(name = "document_type", length = 8, nullable = false)
  private String documentType;

  @Column(name = "document_number", length = 50, nullable = false)
  private String documentNumber;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "surname", length = 100, nullable = false)
  private String surname;

  @Column(name = "lastname", length = 100)
  private String lastname;

  @Column(name = "country", length = 3, nullable = false)
  private String country;

  @Column(name = "telephone")
  private Integer telephone;

  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date updateDate;
}
