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
@Table(name = "customer")

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerEntity {
    @Id
    @Column(length = 10)
    private String customerId;

    @Column(nullable = false, length = 8)
    private String documentType;

    @Column(nullable = false, length = 50)
    private String documentNumber;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String surname;

    @Column(length = 100)
    private String lastname;

    @Column(nullable = false, length = 3)
    private String country;

    @Column
    private Integer telephone;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    ZonedDateTime creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    ZonedDateTime updateDate;

}
