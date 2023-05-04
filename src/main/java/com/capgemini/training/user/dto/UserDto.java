package com.capgemini.training.user.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.capgemini.training.user.entity.User;
import com.capgemini.training.user.service.UserPostService;
import com.capgemini.training.user.service.UserPutService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserDto {
    private static final String NOTBLANK_MESSAGE = " cannot be blank";
    private static final String NOTNULL_MESSAGE = " is mandatory, cannot be null";
    private static final String SIZE_MESSAGE = "The maximum length is ";

    @NotBlank(message = "customerId" + NOTBLANK_MESSAGE)
    @NotNull(message = "customerId" + NOTNULL_MESSAGE)
    @Size(max = 10, message = SIZE_MESSAGE + "10")
    private String customerId;

    @NotNull(message = "documentType" + NOTNULL_MESSAGE)
    @Size(max = 8, message = SIZE_MESSAGE + "8")
    private String documentType;

    @NotNull(message = "documentNumber" + NOTNULL_MESSAGE)
    @Size(max = 50, message = SIZE_MESSAGE + "50")
    private String documentNumber;

    @NotNull(message = "name" + NOTNULL_MESSAGE)
    @Size(max = 100, message = SIZE_MESSAGE + "100")
    private String name;

    @NotNull(message = "surname " + NOTNULL_MESSAGE)
    @Size(max = 100, message = SIZE_MESSAGE + "100")
    private String surname;

    @Size(max = 100, message = SIZE_MESSAGE + "100")
    private String lastname;

    @NotNull(message = "country" + NOTNULL_MESSAGE)
    @Size(max = 3, message = SIZE_MESSAGE + "3")
    private String country;

    private Integer telephone;
    Date creationDate;
    Date updateDate;

    /**
     * Metodo que devuelve un User
     * 
     * @return {@link User}
     * @see UserPutService.update
     */
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
            user.setCreationDate(creationDate);
        if (updateDate != null)
            user.setUpdateDate(updateDate);
        return user;

    }

    /**
     * Metodo que devuelve un User
     * 
     * @return {@link User}
     * @see UserPostService.save
     */
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
        user.setCreationDate(creationDate);
        user.setUpdateDate(updateDate);
        return user;

    }
}
