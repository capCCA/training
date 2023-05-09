package com.capgemini.training.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
/**
 * UserDto @Valid in UserPostController and UserPutController checks these constraints and gets
 * translated into BAD_REQUEST
 * @TODO: give detail of what causes the validation failure
 */
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
}
