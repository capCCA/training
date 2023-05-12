package com.capgemini.training.repositories.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
public class CustomerEntity implements Serializable {

  protected static final long serialVersionUID = 13L;

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

  @Column private LocalDateTime creationDate;

  @Column private LocalDateTime updateDate;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonBackReference
  private Set<PaymentEntity> payments;
}
