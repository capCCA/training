package com.capgemini.training.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author ezorzome
 *
 */
@Entity
@Table(name = "customer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "document_type", nullable = false)
    private String documentType;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "document_number", nullable = false)
    private String documentNumber;

    @Column(name = "sur_name", nullable = false)
    private String surName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "telephone")
    private Integer telephone;

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Date updateDate;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    Set<PaymentEntity> payments;
    //set  lista q no puede repetir elementos

}