package com.capgemini.training.user.entity;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @Id
    @Column(name = "customer_id", length = 10)
    private String customerId;

    @Column(name = "Document_type", nullable = false,length = 8)
    private String documentType;

    @Column(name = "Document_number", nullable = false, length = 50)
    private String documentNumber;

    @Column(name = "Name", nullable = false, length = 100 )
    private String name;

    @Column(name = "SurName", nullable = false,length = 100)
    private String surname;

    @Column(name = "LastName",length = 100)
    private String lastname;

    @Column(name = "Country", nullable = false,length = 3)
    private String country;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Creation_date")
    Date creationDate;

    @Column(name = "Update_date")
    Date updateDate;

    /**Metodo que devuelve un dto
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
        dto.setUpdateDate(creationDate);
        dto.setCreationDate(updateDate);
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
