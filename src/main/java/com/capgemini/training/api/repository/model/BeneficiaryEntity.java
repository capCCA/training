package com.capgemini.training.api.repository.model;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

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
