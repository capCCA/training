package com.capgemini.training.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDetails {
  private static final String NOTEMPTY_MESSAGE = " cannot be empty";
  private static final String SIZE_MESSAGE = "The maximum length is ";

  // @NotEmpty is both
  @NotEmpty(message = NOTEMPTY_MESSAGE)
  @Size(max = 10, message = SIZE_MESSAGE + "10")
  private String customerId;

  // private DocumentType documentType;
  private String documentType;

  @NotEmpty(message = NOTEMPTY_MESSAGE)
  @Size(max = 50, message = SIZE_MESSAGE + "50")
  private String documentNumber;

  @NotEmpty(message = NOTEMPTY_MESSAGE)
  @Size(max = 100, message = SIZE_MESSAGE + "100")
  private String name;

  @NotEmpty(message = NOTEMPTY_MESSAGE)
  @Size(max = 100, message = SIZE_MESSAGE + "100")
  private String surname;

  @Size(max = 100, message = SIZE_MESSAGE + "100")
  private String lastname;

  @NotEmpty(message = NOTEMPTY_MESSAGE)
  @Size(max = 3, message = SIZE_MESSAGE + "3")
  private String country;

  private Integer telephone;
}
