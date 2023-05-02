package com.capgemini.training.user.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "User")
public class User {
//    @Id
//    @Column(name = "customer_id", length = 10)
//    private String customerId;

    @Id
    @GeneratedValue
    @Column(name = "customer_id", nullable = false)
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
    private String country;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Creation_date", nullable = false)
    Timestamp creationDate;

    @Column(name = "Update_date")
    Timestamp updateDate;

    // TODO test
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
        dto.setUpdateDate(creationDate);
        dto.setCreationDate(updateDate);
        return dto;

    }

    // TODO test in save
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
        if (creationDate != null)
            dto.setUpdateDate(creationDate);
        if (updateDate != null)
            dto.setCreationDate(updateDate);
        return dto;

    }
}
/*
 * {"documentType":"Dni", "documentNumber":"123" "name"="a","surname":"b",
 * "country":"es", "creationDate":"02/05/2023" }
 */
