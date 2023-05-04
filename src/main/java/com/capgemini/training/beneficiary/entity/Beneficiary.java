package com.capgemini.training.beneficiary.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/*
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
*/
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "beneficiary")
public class Beneficiary {
    @Id
    @Column(name = "Beneficiary_id", nullable = false, length = 10)
    private String beneficiaryId;

    @Column(name = "Creation_date", nullable = false)
    Date creationDate;

    @Column(name = "Update_date")
    Date updateDate;

}
