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

  /*  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@JsonBackReference
    private Set<PaymentEntity> payments;*/

    /**
     * relation OneToMany size customer to payment
     */
    //@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "customer_id")
    /*@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PaymentEntity> payment;*/

            //lazy: si no quiero acceder a los payments no hace el select hasta q no acceda al campo payment
            //eager: tu cargalo siempre
            //cascade: si borro user borro todos sus payments
            //orphanRemoval si en la tabla tengo payment con users q los borre, borra los payment sin user
            //mapperBy: campo del paymentEntity q referencia al user
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    Set<PaymentEntity> payments;
    //set es lista q no puede repetir elementos

}