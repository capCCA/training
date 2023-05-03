package com.capgemini.training.dtos;

import com.capgemini.training.models.DocumentType;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {
  private static final String NOTNULL_MESSAGE = "is mandatory, cannot be null";
  private static final String SIZE_MESSAGE = "the length must be less than ";

  @NotNull(message = "customerId " + NOTNULL_MESSAGE)
  @Size(max = 10, message = SIZE_MESSAGE + "10")
  private String customerId;

  @NotNull(message = "documentType " + NOTNULL_MESSAGE)
  private DocumentType documentType;

  @NotNull(message = "documentNumber " + NOTNULL_MESSAGE)
  @Size(max = 50, message = SIZE_MESSAGE + "50")
  private String documentNumber;

  @NotNull(message = "name " + NOTNULL_MESSAGE)
  @Size(max = 100, message = SIZE_MESSAGE + "100")
  private String name;

  @NotNull(message = "surname " + NOTNULL_MESSAGE)
  @Size(max = 100, message = SIZE_MESSAGE + "100")
  private String surname;

  @Size(max = 100, message = SIZE_MESSAGE + "100")
  private String lastname;

  @NotNull(message = "country " + NOTNULL_MESSAGE)
  @Size(max = 3, message = SIZE_MESSAGE + "3")
  private String country;

  private Integer telephone;
  private Date creationDate;
  private Date updateDate;
}
