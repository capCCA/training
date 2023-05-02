package com.caggemini.training.beneficiary;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "Beneficiary")
public class Beneficiary {
//    @Id
//    @Column(name = "Beneficiary_id", nullable = false, length = 10)  
//    private String beneficiaryId;
//
    //Temporary- con id generated
    @Id
    @GeneratedValue
    @Column(name = "Beneficiary_id", nullable = false)
    private Long beneficiaryId;

    @Column(name = "Creation_date", nullable = false)
    Timestamp creationDate;

    @Column(name = "Update_date")
    Timestamp updateDate;
  
}
