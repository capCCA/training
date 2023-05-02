package com.caggemini.training.user.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "User")
public class User {
//    @Id
//    @Column(name = "customer_id", length = 10)
//    private String customerId;

    @Id
    @GeneratedValue
    @Column(name = "customer_id", length = 10)
    private Long customerId;

    @Column(name = "Document_type", nullable = false)
    private String documentType;

    @Column(name = "Document_number", nullable = false)
    private String documentNumber;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "SurName", nullable = false)
    private String surname;

    @Column(name = "LastName")
    private String lastname;

    @Column(name = "Country", nullable = false)
    private String county;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Creation_date", nullable = false)
    Timestamp creationDate;

    @Column(name = "Update_date")
    Timestamp updateDate;
}
