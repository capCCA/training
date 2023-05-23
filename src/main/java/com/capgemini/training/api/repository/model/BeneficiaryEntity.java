package com.capgemini.training.api.repository.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.*;
import java.time.ZonedDateTime;
@Entity
@Table(name = "beneficiary")
@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class BeneficiaryEntity {
  @Id
  @Column(name = "beneficiary_id", nullable = false, length = 10)
  private String beneficiaryId;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    ZonedDateTime updateDate;
}
