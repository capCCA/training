package com.capgemini.training.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ezorzome
 *
 */
@Entity
@Table(name = "beneficiary")
@Getter
@Setter
@Builder
public class BeneficiaryEntity {

    @Id
    @Column(name = "beneficiary_id", nullable = false)
    private String beneficiaryId;

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Date updateDate;

}