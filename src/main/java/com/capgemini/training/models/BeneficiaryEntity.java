package com.capgemini.training.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "beneficiary")
public class BeneficiaryEntity {
  @Id
  @Column(length = 10, nullable = false)
  private String beneficiaryId;

  @Column(nullable = false)
  @CreationTimestamp
  private Date creationDate;

  @UpdateTimestamp private Date updateDate;
}
