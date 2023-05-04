package com.capgemini.training.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capgemini.training.user.controller.UserGetController;
import com.capgemini.training.user.dto.UserDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
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

    private Integer telephone;

    Date creationDate;

    Date updateDate;

    /**
     * Metodo que devuelve un dto
     * 
     * @return {@link UserDto}
     * @see UserGetController findAll y findById
     */
    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.setCustomerId(customerId);
        dto.setDocumentType(documentType);
        dto.setDocumentNumber(documentNumber);
        dto.setName(name);
        dto.setSurname(surname);
        dto.setLastname(lastname);
        dto.setTelephone(telephone);
        dto.setCountry(country);
        dto.setCreationDate(creationDate);
        dto.setUpdateDate(updateDate);
        return dto;

    }

    // Not used. Save uses dto.toUser()
    public UserDto toDto(UserDto dto) {
        if (customerId != null)
            dto.setCustomerId(customerId);

        if (documentType != null)
            dto.setDocumentType(documentType);
        if (documentNumber != null)
            dto.setDocumentNumber(documentNumber);
        if (name != null)
            dto.setName(name);
        if (surname != null)
            dto.setSurname(surname);
        if (lastname != null)
            dto.setLastname(lastname);
        if (telephone != null)
            dto.setTelephone(telephone);
        if (country != null)
            dto.setCountry(country);
        if (updateDate != null)
            dto.setUpdateDate(updateDate);
        if (creationDate != null)
            dto.setCreationDate(creationDate);
        return dto;

    }
}
/*
 * {"documentType":"Dni", "documentNumber":"123" "name"="a","surname":"b",
 * "country":"es", "creationDate":"02/05/2023" }
 */
