package com.capgemini.training.repository.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "beneficiary")
public class BeneficiaryEntity {

    @Id
    @Column( name="beneficiary_id", length = 10, nullable = false )
    private String beneficiaryId;
    @Column( name="creation_date", nullable = false )
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate creationDate;
    @Column( name="update_date" )
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate updateDate;
}
