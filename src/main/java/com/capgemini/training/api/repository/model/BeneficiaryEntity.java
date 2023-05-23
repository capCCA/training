package com.capgemini.training.api.repository.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    ZonedDateTime creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    ZonedDateTime updateDate;
}
