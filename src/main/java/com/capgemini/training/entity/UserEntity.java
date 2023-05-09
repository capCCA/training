package com.capgemini.training.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ccsw
 *
 */
@Entity
@Table(name = "customer")
@Getter
@Setter
//@Builder
public class UserEntity {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private String customer_id;

    @Column(name = "document_type", nullable = false)
    private String Document_type;

    @Column(name = "name", nullable = false)
    private String Name;

    @Column(name = "document_number", nullable = false)
    private String Document_number;

    @Column(name = "sur_name", nullable = false)
    private String SurName;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "country", nullable = false)
    private String Country;

    @Column(name = "telephone")
    private Integer Telephone;

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    private Date Creation_date;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Date Update_date;

}