package com.capgemini.training.api.repository.model;

import javax.persistence.*;
import lombok.*;
import java.time.ZonedDateTime;

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
