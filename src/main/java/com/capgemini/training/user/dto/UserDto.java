package com.capgemini.training.user.dto;

import java.sql.Timestamp;

import com.capgemini.training.user.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserDto {
    private Long customerId;// String later
    private String documentType;
    private String documentNumber;
    private String name;
    private String surname;
    private String lastname;
    private String country;
    private String telephone;
    Timestamp creationDate;
    Timestamp updateDate;

    public User toUser(User user) {
        if (customerId != null)
            user.setCustomerId(customerId);
        if (documentType != null)
            user.setDocumentType(documentType);
        if (documentNumber != null)
            user.setDocumentNumber(documentNumber);
        if (name != null)
            user.setName(name);
        if (surname != null)
            user.setSurname(surname);
        if (lastname != null)
            user.setLastname(lastname);
        if (telephone != null)
            user.setTelephone(telephone);
        if (country != null)
            user.setCountry(country);
        if (creationDate != null)
            user.setUpdateDate(creationDate);
        if (updateDate != null)
            user.setCreationDate(updateDate);
        return user;

    }

    // @todo test
    public User toUser() {
        User user = new User();
        user.setCustomerId(customerId);
        user.setDocumentType(documentType);
        user.setDocumentNumber(documentNumber);
        user.setName(name);
        user.setSurname(surname);
        user.setLastname(lastname);
        user.setTelephone(telephone);
        user.setCountry(country);
        user.setUpdateDate(creationDate);
        user.setCreationDate(updateDate);
        return user;

    }
}
