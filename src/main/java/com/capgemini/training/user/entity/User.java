package com.capgemini.training.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "customer")
public class User {
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
    Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    Date updateDate;

    /**
     * Metodo que devuelve un dto
     * 
     * @return {@link UserDto}
     * @see UserGetController findAll y findById
     */
//    public UserDto toDto() {
//        UserDto dto = new UserDto();
//        dto.setCustomerId(customerId);
//        dto.setDocumentType(documentType);
//        dto.setDocumentNumber(documentNumber);
//        dto.setName(name);
//        dto.setSurname(surname);
//        dto.setLastname(lastname);
//        dto.setTelephone(telephone);
//        dto.setCountry(country);
//        dto.setCreationDate(creationDate);
//        dto.setUpdateDate(updateDate);
//        return dto;
//
//    }

}
