package com.capgemini.training.repositories.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "beneficiary")
public class BeneficiaryEntity implements Serializable {

  protected static final long serialVersionUID = 71L;

  @Id
  @Column(length = 10, nullable = false)
  private String beneficiaryId;

  @Column private LocalDateTime creationDate;

  @Column private LocalDateTime updateDate;
}
